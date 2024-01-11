package com.framework.common.model.vo.sysRole;

import com.framework.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author renbao
 * @since 2024-01-10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "查询角色分页数据入参 VO")
public class FindRolePageListReqVo extends BasePageQuery {

    // todo 添加搜索条件
    /**
     * 用户名称
     */
    private String roleName;
}
