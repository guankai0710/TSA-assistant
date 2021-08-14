package com.ryan.tsa.web.customer.qo;

import com.ryan.tsa.common.qo.BaseQo;
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
public class CustomerQo extends BaseQo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 客户名称/客户账号
     */
    private String customerNameOrAccount;

}
