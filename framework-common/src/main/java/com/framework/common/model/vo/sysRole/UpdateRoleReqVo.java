package com.framework.common.model.vo.sysRole;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
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
@ApiModel(value = "修改角色VO")
public class UpdateRoleReqVo {

    @NotNull(message = "角色 ID 不能为空")
    private Long roleId;

    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    @NotBlank(message = "角色权限字符串不能为空")
    private String roleKey;

    @NotNull(message = "角色顺序不能为空")
    private Integer roleSort;

    // todo 后续补充角色对应的部门 和菜单

    private String remark;
}
