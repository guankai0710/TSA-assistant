package com.ryan.tsa.common.exception;

/**
 * 自定义接口超时异常类
 *
 * @author guankai
 * @date 2021/4/23
 **/
public class ConnectionTimeOutException extends RuntimeException {

    public ConnectionTimeOutException(String message) {
        super(message);
    }
}
