package com.ryan.tsa.common.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 返回前端数据格式
 * </p>
 *
 * @author Ryan
 * @since 2021-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 状态码 */
    private Integer code;

    /** 信息 */
    private String msg;

    /** 数据 */
    private Object data;


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
