package com.ryan.tsa.common.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 接口返回格式
 *
 * @author ryan
 * @date 2021/4/22
 */
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 状态码 */
    private Integer code;

    /** 信息 */
    private String msg;

    /** 数据 */
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result(ResultCode resultCode, Object data) {
        this.code = resultCode.code;
        this.msg = resultCode.msg;
        this.data = data;
    }

    public static Result success(){
        return new Result(ResultCode.SUCCESS, "");
    }

    public static Result success(Object data){
        return new Result(ResultCode.SUCCESS, data);
    }

    public static Result failure(ResultCode resultCode){
        return new Result(resultCode, "");
    }

    public static Result failure(ResultCode resultCode, Object data){
        return new Result(resultCode, data);
    }

}
