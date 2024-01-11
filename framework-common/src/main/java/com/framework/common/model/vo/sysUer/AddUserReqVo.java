package com.framework.common.model.vo.sysUer;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
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
public class AddUserReqVo {

    @NotBlank(message = "用户昵称不能为空")
    private String nickName;

    @NotBlank(message = "用户账号不能为空")
    private String userName;

    @NotBlank(message = "用户密码不能为空")
    private String password;

    // todo 后续补充角色和部门信息


    private String email;

    private String phonenumber;

    private String remark;
}
