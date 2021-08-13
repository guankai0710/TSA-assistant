package com.ryan.tsa.common.qo;

import lombok.Data;

import java.io.Serializable;

/**
 * 类描述：qo基类
 *
 * @author ryan
 * @date 2021/4/25
 **/
@Data
public class BaseQo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 排序字段
     */
    private String order;

    /**
     * 排序方式 是否是 ASC 排序；默认 DESC 倒排序
     */
    private Boolean sort = false;


}
