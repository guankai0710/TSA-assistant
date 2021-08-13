package com.ryan.tsa.common.response;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 类描述：自定义分页数据返回
 *
 * 依赖于Mybatis-Plus
 *
 * @author guankai
 * @date 2021/4/26
 **/
@Data
public class PageResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 当前页 */
    private long pageNum;

    /** 每页的数量 */
    private long pageSize;

    /** 总条数 */
    private long total;

    /** 数据集合 */
    private List<T> list;

    public PageResponse(Page<T> page) {
        this.pageNum = page.getCurrent();
        this.pageSize = page.getSize();
        this.total = page.getTotal();
        this.list = page.getRecords();
    }

    public static <T> PageResponse<T> of(Page<T> page){
        return new PageResponse<T>(page);
    }
}
