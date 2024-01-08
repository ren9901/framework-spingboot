package com.framework.common.aspect;

import java.lang.annotation.*;

/**
 * 自定义日志注解
 * @author renbao
 * @since 2024-01-08
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ApiOperationLog {
    /**
     * API 功能描述
     *
     * @return
     */
    String description() default "";

}
