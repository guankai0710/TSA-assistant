package com.ryan.tsa.miniapp.product.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 产品信息 
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Data
public class ProductVo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 产品类别id
     */
    private Integer productCategoryId;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 推荐星级
     */
    private String star;

    /**
     * 起购金额
     */
    private BigDecimal leastAmount;

    /**
     * 备注
     */
    private String memo;


}
