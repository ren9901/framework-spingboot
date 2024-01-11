package com.framework.admin.controller;

import com.framework.common.model.vo.sysUer.*;
import com.framework.common.aspect.ApiOperationLog;
import com.framework.common.domain.service.ISysUserService;
import com.framework.common.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制层
 * @author renbao
 * @since 2024-01-10
 */
@RestController
@RequestMapping("/admin/user")
@Api(tags = "用户模块")
public class SysUserController {

    @Autowired
    private ISysUserService userService;

    @PostMapping("/info")
    @ApiOperation(value = "获取登录用户信息")
    @ApiOperationLog(description = "获取登录用户信息")
    public Response findUserInfo() {
        return userService.findUserInfo();
    }

    @PostMapping("/list")
    @ApiOperation(value = "查询用户分页数据")
    @ApiOperationLog(description = "查询用户分页数据")
    public Response findUserPageList(@RequestBody @Validated FindUserPageListReqVo findUserPageListReqVo){
        return userService.findUserPageList(findUserPageListReqVo);
    }

    @PostMapping("/view")
    @ApiOperation(value = "查看用户")
    @ApiOperationLog(description = "查看用户")
    public Response viewSysUser(@RequestBody @Validated ViewUserReqVo viewUserReqVo){
        return userService.viewSysUser(viewUserReqVo);
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加用户")
    @ApiOperationLog(description = "添加用户")
    public Response addSysUser(@RequestBody @Validated AddUserReqVo addUserReqVo){
        userService.addSysUser(addUserReqVo);
        return Response.success();
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除用户")
    @ApiOperationLog(description = "删除用户")
    public Response deleteSysUser(@RequestBody @Validated ViewUserReqVo viewUserReqVo){
        userService.deleteSysUser(viewUserReqVo);
        return Response.success();
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新用户")
    @ApiOperationLog(description = "更新用户")
    public Response updateSysUser(@RequestBody @Validated UpdateUserReqVo updateUserReqVo){
        userService.updateSysUser(updateUserReqVo);
        return Response.success();
    }

    @PostMapping("/updatePassword")
    @ApiOperation(value = "修改用户密码")
    @ApiOperationLog(description = "修改用户密码")
    public Response updatePassword(@RequestBody @Validated UpdataPassWordReqVo updataPassWordReqVo){
        userService.updatePassword(updataPassWordReqVo);
        return Response.success();
    }


}
