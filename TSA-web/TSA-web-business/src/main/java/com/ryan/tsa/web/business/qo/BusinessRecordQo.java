package com.ryan.tsa.web.business.qo;

import com.ryan.tsa.common.qo.BaseQo;
import lombok.Data;

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
public class BusinessRecordQo extends BaseQo implements Serializable {

    private static final long serialVersionUID=1L;


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
     * 买入时间
     */
    private String buyTime;

    /**
     * 交易状态
     */
    private Integer status;

    /**
     * 卖出时间
     */
    private String sellTime;

    /**
     * 收益率
     */
    private BigDecimal incomeRate;


}
