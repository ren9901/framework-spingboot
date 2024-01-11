package com.framework.common.model.vo.sysRole;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 *
 * @author renbao
 * @since 2024-01-10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "查看角色详情 VO")
public class ViewRoleReqVo {
    /**
     * 用户 ID
     */
    @NotNull(message = "用户 ID 不能为空")
    private Long roleId;
}
