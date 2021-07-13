package com.ryan.tsa.common.exception;

/**
 * 自定义参数缺失异常
 *
 * @author ryan
 * @date 2021/7/13
 **/
public class ParamNotExistException extends RuntimeException {

    public ParamNotExistException(String message) {
        super(message);
    }
}
