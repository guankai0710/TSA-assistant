package com.ryan.tsa.common.qo;

import lombok.Data;

/**
 * 类描述：qo基类
 *
 * @author guankai
 * @date 2021/4/25
 **/
@Data
public class BaseQo {

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 获取分页开始位置
     * @return
     */
    public Integer getPageNum() {
        return ((this.pageNum-1) * this.pageSize);
    }
}
