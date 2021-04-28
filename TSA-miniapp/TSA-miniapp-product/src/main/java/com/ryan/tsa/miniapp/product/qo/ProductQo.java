package com.ryan.tsa.miniapp.product.qo;

import com.ryan.tsa.common.qo.BaseQo;
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
public class ProductQo extends BaseQo implements Serializable {

    private static final long serialVersionUID=1L;


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


}
