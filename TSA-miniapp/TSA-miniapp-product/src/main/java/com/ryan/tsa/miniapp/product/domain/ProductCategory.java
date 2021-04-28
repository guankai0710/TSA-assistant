package com.ryan.tsa.miniapp.product.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 产品类别 
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tsa_app_product_category")
public class ProductCategory implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 产品类别id
     */
    @TableId(value = "product_category_id", type = IdType.AUTO)
    private Integer productCategoryId;

    /**
     * 产品类别名称
     */
    @TableField("name")
    private String name;

    /**
     * 备注
     */
    @TableField("memo")
    private String memo;

    /**
     * 创建时间
     */
    @TableField(value = "created_time",fill = FieldFill.INSERT)
    private Date createdTime;

    /**
     * 更新时间
     */
    @TableField(value = "updated_time",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    /**
     * 是否删除(1:是；0:否)
     */
    @TableField("deleted")
    private String deleted;


}
