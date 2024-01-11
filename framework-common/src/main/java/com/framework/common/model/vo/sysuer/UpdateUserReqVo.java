package com.framework.common.model.vo.sysuer;

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
@ApiModel(value = "添加用户VO")
public class UpdateUserReqVo {

    /**
     * 用户 ID
     */
    @NotNull(message = "用户 ID 不能为空")
    private Long userId;

    @NotBlank(message = "用户昵称不能为空")
    private String nickName;


    // todo 后续补充角色和部门信息


    private String email;

    private String phonenumber;

    private String remark;
}
