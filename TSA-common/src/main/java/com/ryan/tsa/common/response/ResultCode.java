package com.ryan.tsa.common.response;

/**
 * 返回状态码枚举类
 *
 * @author ryan
 * @date 2021/4/22
 */
public enum ResultCode {

    // 成功状态码：200
    SUCCESS(200, "请求成功"),

    // 参数错误：1001~1999
    PARAM_IS_ERROR(1001, "参数异常"),
    PARAM_IS_INVALID(1002, "参数无效"),
    PARAM_NOT_EXIST(1003, "参数缺失"),
    PARAM_TYPE_BIND_ERROR(1004, "参数类型错误"),

    // 用户错误：2001~2999
    USER_NOT_LOGIN(2001, "用户未登录"),
    USER_LOGIN_ERROR(2002, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(2003, "账号已被禁用"),
    USER_NOT_EXIST(2004, "用户不存在"),
    USER_HAS_EXISTED(2005, "用户已存在"),

    TOKEN_NOT_EXIST(2006, "Token缺失"),
    TOKEN_ERROR(2007, "Token异常或过期"),

    // 接口错误：3001~3999
    INTERFACE_CONNECTION_TIME_OUT(3001, "接口连接超时"),

    // 客户端异常：
    CLIENT_NOT_FOUND(404, "404异常"),

    // 服务器异常：500
    SERVER_ERROR(500, "服务器异常，请联系管理员");




    /** 状态码 */
    Integer code;

    /** 信息 */
    String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
