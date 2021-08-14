package com.ryan.tsa.web.customer.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class CustomerVo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 客户id
     */
    private Integer customerId;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户账号
     */
    private String customerAccount;

    /**
     * 客户密码
     */
    private String customerPassword;

    /**
     * 充值资金
     */
    private BigDecimal rechargeMoney;

    /**
     * 剩余资金
     */
    private BigDecimal lastMoney;

    /**
     * 电话
     */
    private String tel;

    /**
     * 地址
     */
    private String addr;


}
