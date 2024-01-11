package com.framework.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.common.domain.entity.SysUser;
import com.framework.common.model.vo.sysuer.FindUserPageListReqVo;
import com.framework.common.model.vo.sysuer.UpdateUserReqVo;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author renbao
 * @since 2024-01-09
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    default SysUser findByUsername(String username) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUserName, username);
        return selectOne(queryWrapper);
    }

    default void updatePasswordByUsername(String username, String password) {
        LambdaUpdateWrapper<SysUser> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(SysUser::getPassword, password);
        wrapper.set(SysUser::getUpdateTime, LocalDateTime.now());
        // 更新条件
        wrapper.eq(SysUser::getUserName, username);

        update(null, wrapper);

    }

    Page<SysUser> selectPageList(Page<SysUser> page, @Param("qo") FindUserPageListReqVo findUserPageListReqVo);

    void updateSysUser(UpdateUserReqVo updateUserReqVo);
}
