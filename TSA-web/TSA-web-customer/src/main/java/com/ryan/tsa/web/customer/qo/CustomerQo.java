package com.ryan.tsa.web.customer.qo;

import com.ryan.tsa.common.qo.BaseQo;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 客户信息 
 * </p>
 *
 * @author ryan
 * @since 2021-07-12
 */
@Data
public class CustomerQo extends BaseQo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户账号
     */
    private String customerAccount;


}
