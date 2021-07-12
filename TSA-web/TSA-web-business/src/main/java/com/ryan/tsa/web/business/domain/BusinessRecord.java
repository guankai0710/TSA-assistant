package com.ryan.tsa.web.business.domain;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 交易记录 
 * </p>
 *
 * @author ryan
 * @since 2021-07-12
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
    @TableField("created_time")
    private String createdTime;

    /**
     * 更新时间
     */
    @TableField("updated_time")
    private String updatedTime;

    /**
     * 是否删除(1:是；0:否)
     */
    @TableField("deleted")
    private Integer deleted;


}
