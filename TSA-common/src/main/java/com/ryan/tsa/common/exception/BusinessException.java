package com.ryan.tsa.common.exception;

import com.ryan.tsa.common.response.ResultCode;
import lombok.Data;

/**
 * 自定义业务异常
 *
 * @author ryan
 * @date 2021/7/17
 **/
@Data
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码枚举
     */
    private ResultCode resultCode;

    public BusinessException(){

    }

    public BusinessException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

}
