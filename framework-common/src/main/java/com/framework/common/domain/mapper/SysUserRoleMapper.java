package com.framework.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.framework.common.domain.entity.SysUser;
import com.framework.common.domain.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户和角色关联表 Mapper 接口
 * </p>
 *
 * @author renbao
 * @since 2024-01-09
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    default SysUserRole getRoleByUserId(Long userId){
        LambdaQueryWrapper<SysUserRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUserRole::getUserId, userId);
        return selectOne(queryWrapper);
    }
}
