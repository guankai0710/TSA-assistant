package com.ryan.tsa.common.exception;

import com.ryan.tsa.common.response.Result;
import com.ryan.tsa.common.response.ResultCode;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
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
    @ExceptionHandler(value = {BindException.class, MethodArgumentNotValidException.class})
    public Result methodArgumentNotValidExceptionHandler(Exception exception) {
        log.error("GlobalExceptionHandler 请求参数异常：", exception);
        return Result.failure(ResultCode.PARAM_IS_ERROR);
    }

    /**
     * 请求参数缺失异常
     *
     * @param exception 异常
     * @return
     */
    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public Result missingServletRequestParameterExceptionHandler(Exception exception) {
        log.error("GlobalExceptionHandler 请求参数异常：", exception);
        return Result.failure(ResultCode.PARAM_NOT_EXIST);
    }

    /**
     * 请求参数缺失异常
     *
     * @param exception 异常
     * @return
     */
    @ExceptionHandler(value = {ParamNotExistException.class})
    public Result paramNotExistExceptionHandler(Exception exception) {
        log.error("请求参数缺失：", exception);
        return Result.failure(ResultCode.PARAM_NOT_EXIST);
    }

    /**
     * 用户已存在异常
     *
     * @param exception 异常
     * @return
     */
    @ExceptionHandler(value = {UserHasExistException.class})
    public Result userHasExistExceptionHandler(Exception exception) {
        log.error("用户已存在：", exception);
        return Result.failure(ResultCode.USER_HAS_EXISTED);
    }

    /**
     * 请求参数类型异常
     *
     * @param exception 异常
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public Result methodArgumentTypeMismatchExceptionHandler(Exception exception) {
        log.error("GlobalExceptionHandler 请求参数异常：", exception);
        return Result.failure(ResultCode.PARAM_TYPE_BIND_ERROR);
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
     * JWTtoken异常
     *
     * @param exception 异常
     * @return
     */
    @ExceptionHandler(value = {JwtException.class})
    public Result expiredJwtExceptionHandler(Exception exception) {
        log.error("GlobalExceptionHandler JwtException异常：", exception);
        return Result.failure(ResultCode.TOKEN_ERROR);
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
