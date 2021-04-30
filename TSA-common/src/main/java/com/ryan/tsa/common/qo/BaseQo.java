package com.ryan.tsa.common.qo;

import com.ryan.tsa.common.enumerate.YesOrNo;
import lombok.Data;

import java.io.Serializable;

/**
 * 类描述：qo基类
 *
 * @author guankai
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

    // 使用分页插件后不需要自己计算
//    /**
//     * 获取分页开始位置
//     * @return
//     */
//    public Integer getPageNum() {
//        return ((this.pageNum-1) * this.pageSize);
//    }

    /**
     * 是否删除(1:是；0:否)
     */
    private Integer deleted = YesOrNo.NO.getValue();
}
