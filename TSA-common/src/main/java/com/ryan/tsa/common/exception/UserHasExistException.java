package com.ryan.tsa.common.exception;

/**
 * 自定义用户已存在异常
 *
 * @author ryan
 * @date 2021/7/13
 **/
public class UserHasExistException extends RuntimeException {

    public UserHasExistException(String message) {
        super(message);
    }
}
