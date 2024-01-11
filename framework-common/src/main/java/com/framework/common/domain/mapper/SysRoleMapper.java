package com.framework.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.common.domain.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.framework.common.domain.entity.SysUser;
import com.framework.common.model.vo.sysRole.FindRolePageListReqVo;
import com.framework.common.model.vo.sysRole.UpdateRoleReqVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author renbao
 * @since 2024-01-09
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    default List<SysRole> selectByUserId(Long roleId) {
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRole::getRoleId, roleId);
        return selectList(wrapper);
    }

    Page<SysRole> selectPageList(Page<SysRole> page, @Param("qo") FindRolePageListReqVo findRolePageListReqVo);

    void updataSysRole(UpdateRoleReqVo updateRoleReqVo);
}
