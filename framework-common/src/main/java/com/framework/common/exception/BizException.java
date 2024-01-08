package com.framework.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author renxiansheng
 * @date 2023/10/20 10:14
 * @description: 业务异常
 */
@Getter
@Setter
public class BizException extends RuntimeException {
    // 异常码
    private String errorCode;
    // 错误信息
    private String errorMessage;

    public BizException(BaseExceptionInterface baseExceptionInterface) {
        this.errorCode = baseExceptionInterface.getErrorCode();
        this.errorMessage = baseExceptionInterface.getErrorMessage();
    }
}
