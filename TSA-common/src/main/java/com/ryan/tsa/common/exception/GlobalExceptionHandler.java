package com.ryan.tsa.common.exception;

import com.ryan.tsa.common.response.Result;
import com.ryan.tsa.common.response.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;


/**
 * 全局异常处理
 *
 * @author ryan
 * @date 2021/4/22
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 请求参数异常
     *
     * @param exception 异常
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
    public Result methodArgumentNotValidExceptionHandler(Exception exception) {
        log.error("GlobalExceptionHandler 请求参数异常：", exception);
        return Result.failure(ResultCode.PARAM_IS_ERROR);
    }

    /**
     * 404异常
     *
     * @param exception 异常
     * @return
     */
    @ExceptionHandler(value = {NoHandlerFoundException.class})
    public Result noHandlerExceptionHandler(Exception exception) {
        log.error("GlobalExceptionHandler NoHandlerFoundException异常：", exception);
        return Result.failure(ResultCode.CLIENT_NOT_FOUND);
    }

    /**
     * 自定义接口超时异常
     *
     * @param exception 异常
     * @return
     */
    @ExceptionHandler(value = {ConnectionTimeOutException.class})
    public Result connectionTimeOutExceptionHandler(Exception exception) {
        log.error("GlobalExceptionHandler ConnectionTimeOutException异常：", exception);
        return Result.failure(ResultCode.INTERFACE_CONNECTION_TIME_OUT);
    }

    /**
     * 其他异常处理
     *
     * @param exception 异常
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public Result exceptionHandler(Exception exception) {
        log.error("GlobalExceptionHandler 异常：", exception);
        return Result.failure(ResultCode.SERVER_ERROR);
    }
}
