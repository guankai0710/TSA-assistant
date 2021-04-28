package com.ryan.tsa.miniapp.product.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 产品类别 
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Data
public class ProductCategoryVo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 产品类别id
     */
    private Integer productCategoryId;

    /**
     * 产品类别名称
     */
    private String name;

    /**
     * 备注
     */
    private String memo;


}
