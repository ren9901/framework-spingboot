package com.framework.common.domain.service;

import com.framework.common.domain.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.framework.common.model.vo.sysRole.AddRoleReqVo;
import com.framework.common.model.vo.sysRole.FindRolePageListReqVo;
import com.framework.common.model.vo.sysRole.UpdateRoleReqVo;
import com.framework.common.model.vo.sysRole.ViewRoleReqVo;
import com.framework.common.utils.Response;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author renbao
 * @since 2024-01-09
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
     * 角色列表
     * @return
     */
    Response findRolePageList(FindRolePageListReqVo findRolePageListReqVo);

    /**
     * 查看角色详情
     * @return
     */
    Response viewSysRole(ViewRoleReqVo viewRoleReqVo);

    /**
     * 添加角色
     * @return
     */
    void addSysRole(AddRoleReqVo addRoleReqVo);
    /**
     * 修改角色
     * @return
     */
    void updateSysRole(UpdateRoleReqVo updateRoleReqVo);
    /**
     * 删除角色
     * @return
     */
    void deleteSysUser(ViewRoleReqVo viewRoleReqVo);
}
