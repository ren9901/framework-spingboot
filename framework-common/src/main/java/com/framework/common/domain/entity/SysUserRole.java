package com.framework.common.domain.entity;

import java.io.Serializable;

import lombok.*;

/**
 * <p>
 * 用户和角色关联表
 * </p>
 *
 * @author renbao
 * @since 2024-01-09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;


}
