package com.framework.admin.controller;

import com.framework.common.aspect.ApiOperationLog;
import com.framework.common.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author renbao
 * @since 2024-01-09
 */
@RestController
@Slf4j
@Api(tags = "测试")
public class Test {

    @PostMapping("/admin/update")
    @ApiOperationLog(description = "测试更新接口")
    @ApiOperation(value = "测试更新接口")
    @PreAuthorize("hasAuthority('admin')")
    public Response testUpdate() {
        log.info("更新成功...");
        return Response.success();
    }
}
