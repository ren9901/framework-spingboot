package com.framework.common.domain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.framework.common.domain.entity.SysUser;
import com.framework.common.domain.entity.SysUserRole;
import com.framework.common.domain.mapper.SysUserMapper;
import com.framework.common.domain.mapper.SysUserRoleMapper;
import com.framework.common.domain.service.ISysUserService;
import com.framework.common.enums.ResponseCodeEnum;
import com.framework.common.exception.BizException;
import com.framework.common.model.vo.sysuer.*;
import com.framework.common.utils.PageResponse;
import com.framework.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author renbao
 * @since 2024-01-09
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SysUserRoleMapper userRoleMapper;

    /**
     * 获取当前登录用户信息
     * @return
     */
    @Override
    public Response findUserInfo() {
        // 获取存储在 ThreadLocal 中的用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 拿到用户名
        String username = authentication.getName();

        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUser::getUserName, username);
        SysUser sysUser = userMapper.selectOne(wrapper);

        // todo 后续封装vo返回权限等内容
        return Response.success(sysUser);
    }

    @Override
    public Response findUserPageList(FindUserPageListReqVo findUserPageListReqVo) {
        Page<SysUser> page = new Page<>(findUserPageListReqVo.getCurrent(), findUserPageListReqVo.getSize());

        Page<SysUser> userPage = userMapper.selectPageList(page, findUserPageListReqVo);
        List<SysUser> records = userPage.getRecords();

        // todo 后续可以进行 DO 转 VO

        return PageResponse.success(userPage, records);
    }

    @Override
    public Response viewSysUser(ViewUserReqVo viewUserReqVo) {
        Long userId = viewUserReqVo.getUserId();

        SysUser sysUser = userMapper.selectById(userId);

        if(Objects.isNull(sysUser)){
            throw new BizException(ResponseCodeEnum.USER_NAME_NOT_EXISTED);
        }

        // todo 查出用户对应的 角色和权限等

        // todo 返回的数据 封装成Rsp Vo

        return Response.success(sysUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addSysUser(AddUserReqVo addUserReqVo) {
        String userName = addUserReqVo.getUserName();
        //判断用户是否存在
        Long count = userMapper.selectCount(new QueryWrapper<SysUser>().lambda().eq(SysUser::getUserName, userName));

        if(count > 0){
            throw new BizException(ResponseCodeEnum.USER_NAME_IS_EXISTED);
        }
        // 密码加密
        String encodePassword = passwordEncoder.encode(addUserReqVo.getPassword());

        SysUser build = SysUser.builder().userName(userName).nickName(addUserReqVo.getNickName())
                .password(encodePassword).email(addUserReqVo.getEmail()).phonenumber(addUserReqVo.getPhonenumber())
                .remark(addUserReqVo.getRemark())
                .createTime(LocalDateTime.now()).build();

        userMapper.insert(build);

        SysUser sysUser = userMapper.selectOne(new QueryWrapper<SysUser>().lambda().eq(SysUser::getUserName, userName));
        // todo 先默认添加的角色为普通角色 common
        userRoleMapper.insert(SysUserRole.builder().userId(sysUser.getUserId()).roleId(2L).build());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSysUser(ViewUserReqVo viewUserReqVo) {
        Long userId = viewUserReqVo.getUserId();
        userMapper.deleteById(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSysUser(UpdateUserReqVo updateUserReqVo) {
        // todo 后续补充遍历 部门 角色等
        userMapper.updateSysUser(updateUserReqVo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(UpdataPassWordReqVo updataPassWordReqVo) {
        String userName = updataPassWordReqVo.getUserName();
        String password = updataPassWordReqVo.getPassword();

        // 加密密码
        String encodePassword = passwordEncoder.encode(password);

        userMapper.updatePasswordByUsername(userName, encodePassword);
    }

}
