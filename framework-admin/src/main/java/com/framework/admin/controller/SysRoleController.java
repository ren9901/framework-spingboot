package com.framework.admin.controller;

import com.framework.common.aspect.ApiOperationLog;
import com.framework.common.domain.service.ISysRoleService;
import com.framework.common.model.vo.sysRole.AddRoleReqVo;
import com.framework.common.model.vo.sysRole.FindRolePageListReqVo;
import com.framework.common.model.vo.sysRole.UpdateRoleReqVo;
import com.framework.common.model.vo.sysRole.ViewRoleReqVo;
import com.framework.common.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色控制层
 * @author renbao
 * @since 2024-01-11
 */
@RestController
@RequestMapping("/admin/role")
@Api(tags = "角色模块")
public class SysRoleController {

    @Autowired
    private ISysRoleService roleService;

    @PostMapping("/list")
    @ApiOperation(value = "查询角色分页数据")
    @ApiOperationLog(description = "查询角色分页数据")
    public Response findRolePageList(@RequestBody @Validated FindRolePageListReqVo findRolePageListReqVo) {
        return roleService.findRolePageList(findRolePageListReqVo);
    }

    @PostMapping("/view")
    @ApiOperation(value = "查看角色")
    @ApiOperationLog(description = "查看角色")
    public Response viewSysRole(@RequestBody @Validated ViewRoleReqVo viewRoleReqVo) {
        return roleService.viewSysRole(viewRoleReqVo);
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加角色")
    @ApiOperationLog(description = "添加角色")
    public Response addSysRole(@RequestBody @Validated AddRoleReqVo addRoleReqVo) {
        roleService.addSysRole(addRoleReqVo);
        return Response.success();
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新角色")
    @ApiOperationLog(description = "更新角色")
    public Response updateSysRole(@RequestBody @Validated UpdateRoleReqVo updateRoleReqVo) {
        roleService.updateSysRole(updateRoleReqVo);
        return Response.success();
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除角色")
    @ApiOperationLog(description = "删除角色")
    public Response deleteSysUser(@RequestBody @Validated ViewRoleReqVo viewRoleReqVo) {
        roleService.deleteSysUser(viewRoleReqVo);
        return Response.success();
    }
}
