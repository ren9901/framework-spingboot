package com.framework.common.model.vo.sysuer;

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
@ApiModel(value = "查询用户分页数据入参 VO")
public class FindUserPageListReqVo extends BasePageQuery {

    // todo 添加搜索条件
    /**
     * 用户名称
     */
    private String userName;
}
