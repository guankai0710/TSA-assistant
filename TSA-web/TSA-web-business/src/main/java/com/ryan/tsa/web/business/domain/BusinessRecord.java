package com.ryan.tsa.web.business.domain;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 交易记录
 * </p>
 *
 * @author Ryan
 * @since 2021-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tsa_business_record")
public class BusinessRecord implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 交易id
     */
    @TableId(value = "business_id", type = IdType.AUTO)
    private Integer businessId;

    /**
     * 用户id
     */
    @TableField("person_id")
    private Integer personId;

    /**
     * 客户id
     */
    @TableField("customer_id")
    private Integer customerId;

    /**
     * 股票名称
     */
    @TableField("stock_name")
    private String stockName;

    /**
     * 股票代码
     */
    @TableField("stock_code")
    private String stockCode;

    /**
     * 买入数量
     */
    @TableField("buy_number")
    private Integer buyNumber;

    /**
     * 成本价
     */
    @TableField("buy_price")
    private BigDecimal buyPrice;

    /**
     * 买入时间
     */
    @TableField("buy_time")
    private String buyTime;

    /**
     * 交易状态
     */
    @TableField("status")
    private Integer status;

    /**
     * 卖出价
     */
    @TableField("sell_price")
    private BigDecimal sellPrice;

    /**
     * 卖出时间
     */
    @TableField("sell_time")
    private String sellTime;

    /**
     * 收益率
     */
    @TableField("income_rate")
    private BigDecimal incomeRate;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField(value = "created_time",fill = FieldFill.INSERT)
    private String createdTime;

    /**
     * 更新时间
     */
    @TableField(value = "updated_time",fill = FieldFill.INSERT_UPDATE)
    private String updatedTime;


}
