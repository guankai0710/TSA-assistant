package com.ryan.tsa.common.exception;

import com.ryan.tsa.common.response.ResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 自定义业务异常
 * </p>
 *
 * @author Ryan
 * @since 2021-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码枚举
     */
    private ResultCode resultCode;

    public BusinessException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

}
