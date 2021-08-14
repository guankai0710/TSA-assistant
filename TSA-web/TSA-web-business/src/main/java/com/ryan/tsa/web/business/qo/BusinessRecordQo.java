package com.ryan.tsa.web.business.qo;

import com.ryan.tsa.common.qo.BaseQo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
     * 股票名称/股票代码
     */
    private String stockNameOrStockCode;

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


}
