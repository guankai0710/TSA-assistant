package com.ryan.tsa.common.response;

import com.github.pagehelper.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 类描述：自定义分页数据返回
 *
 * 依赖于PageHelper分页插件
 *
 * @author guankai
 * @date 2021/4/26
 **/
@Data
public class PageResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 当前页 */
    private int pageNum;

    /** 每页的数量 */
    private int pageSize;

    /** 总条数 */
    private long total;

    /** 数据集合 */
    private List<T> list;

    public PageResponse(List<T> list) {
        this.list = list;
        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.total = page.getTotal();
        } else {
            this.pageNum = 1;
            this.pageSize = list.size();
            this.total = list.size();
        }
    }

    public static <T> PageResponse<T> of(List<T> list){
        return new PageResponse<T>(list);
    }
}
