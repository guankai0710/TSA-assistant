package com.ryan.tsa.web.customer.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 客户信息 
 * </p>
 *
 * @author ryan
 * @since 2021-07-12
 */
@Data
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
