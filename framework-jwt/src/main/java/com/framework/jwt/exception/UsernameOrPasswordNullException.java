package com.framework.jwt.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author renxiansheng
 * @date 2023/10/23 17:25
 * @description: 用户名或者密码为空异常
 */
public class UsernameOrPasswordNullException extends AuthenticationException {
    public UsernameOrPasswordNullException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public UsernameOrPasswordNullException(String msg) {
        super(msg);
    }
}
