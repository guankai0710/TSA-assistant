package com.ryan.tsa.web.customer.domain;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 客户信息
 * </p>
 *
 * @author Ryan
 * @since 2021-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@TableName("tsa_customer")
public class Customer implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 客户id
     */
    @TableId(value = "customer_id", type = IdType.AUTO)
    private Integer customerId;

    /**
     * 客户名称
     */
    @TableField("customer_name")
    private String customerName;

    /**
     * 客户账号
     */
    @TableField("customer_account")
    private String customerAccount;

    /**
     * 客户密码
     */
    @TableField("customer_password")
    private String customerPassword;

    /**
     * 充值资金
     */
    @TableField("recharge_money")
    private BigDecimal rechargeMoney;

    /**
     * 剩余资金
     */
    @TableField("last_money")
    private BigDecimal lastMoney;

    /**
     * 电话
     */
    @TableField("tel")
    private String tel;

    /**
     * 地址
     */
    @TableField("addr")
    private String addr;

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
