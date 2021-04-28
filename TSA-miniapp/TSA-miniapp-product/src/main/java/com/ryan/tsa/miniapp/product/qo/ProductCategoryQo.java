package com.ryan.tsa.miniapp.product.qo;

import com.ryan.tsa.common.qo.BaseQo;
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
public class ProductCategoryQo extends BaseQo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 产品类别名称
     */
    private String name;



}
