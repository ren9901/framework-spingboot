package com.framework.common.domain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.framework.common.domain.entity.SysRole;
import com.framework.common.domain.mapper.SysRoleMapper;
import com.framework.common.domain.service.ISysRoleService;
import com.framework.common.enums.ResponseCodeEnum;
import com.framework.common.exception.BizException;
import com.framework.common.model.vo.sysRole.AddRoleReqVo;
import com.framework.common.model.vo.sysRole.FindRolePageListReqVo;
import com.framework.common.model.vo.sysRole.UpdateRoleReqVo;
import com.framework.common.model.vo.sysRole.ViewRoleReqVo;
import com.framework.common.utils.PageResponse;
import com.framework.common.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author renbao
 * @since 2024-01-09
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public Response findRolePageList(FindRolePageListReqVo findRolePageListReqVo) {
        Page<SysRole> page = new Page<>(findRolePageListReqVo.getCurrent(), findRolePageListReqVo.getSize());


        Page<SysRole> userPage = roleMapper.selectPageList(page, findRolePageListReqVo);
        List<SysRole> records = userPage.getRecords();

        // todo 后续可以进行 DO 转 VO

        return PageResponse.success(userPage, records);
    }

    @Override
    public Response viewSysRole(ViewRoleReqVo viewRoleReqVo) {
        Long roleId = viewRoleReqVo.getRoleId();
        SysRole sysRole = roleMapper.selectById(roleId);

        if(Objects.isNull(sysRole)){
            throw new BizException(ResponseCodeEnum.ROLE_NAME_NOT_EXISTED);
        }

        return Response.success(sysRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addSysRole(AddRoleReqVo addRoleReqVo) {
        String roleName = addRoleReqVo.getRoleName();

        Long count = roleMapper.selectCount(new QueryWrapper<SysRole>().lambda().eq(SysRole::getRoleName, roleName));

        if(count > 0){
            throw new BizException(ResponseCodeEnum.ROLE_NAME_IS_EXISTED);
        }

        SysRole sysRole = SysRole.builder().roleName(roleName).roleKey(addRoleReqVo.getRoleKey())
                .roleSort(addRoleReqVo.getRoleSort())
                .remark(addRoleReqVo.getRemark())
                .createTime(LocalDateTime.now())
                .build();

        roleMapper.insert(sysRole);

        //TODO 后续补充角色对应的部门 和菜单权限
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSysRole(UpdateRoleReqVo updateRoleReqVo) {
        roleMapper.updataSysRole(updateRoleReqVo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSysUser(ViewRoleReqVo viewRoleReqVo) {
        Long roleId = viewRoleReqVo.getRoleId();
        roleMapper.deleteById(roleId);
    }
}
