package com.ryan.tsa.web.business.vo;

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
 * 交易记录 
 * </p>
 *
 * @author ryan
 * @since 2021-07-12
 */
@Data
public class BusinessRecordVo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 交易id
     */
    private Integer businessId;

    /**
     * 用户id
     */
    private Integer personId;

    /**
     * 客户id
     */
    private Integer customerId;

    /**
     * 股票名称
     */
    private String stockName;

    /**
     * 股票代码
     */
    private String stockCode;

    /**
     * 买入数量
     */
    private Integer buyNumber;

    /**
     * 成本价
     */
    private BigDecimal buyPrice;

    /**
     * 买入时间
     */
    private String buyTime;

    /**
     * 交易状态
     */
    private Integer status;

    /**
     * 卖出价
     */
    private BigDecimal sellPrice;

    /**
     * 卖出时间
     */
    private String sellTime;

    /**
     * 收益率
     */
    private BigDecimal incomeRate;

    /**
     * 备注
     */
    private String remark;


}
