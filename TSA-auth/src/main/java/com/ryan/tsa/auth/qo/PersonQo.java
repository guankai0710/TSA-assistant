package com.ryan.tsa.auth.qo;

import com.ryan.tsa.common.qo.BaseQo;
import lombok.Data;

/**
 * <p>
 * 用户 
 * </p>
 *
 * @author ryan
 * @since 2021-04-23
 */
@Data
public class PersonQo extends BaseQo {

    /**
     * 用户名称
     */
    private String personName;

    /**
     * 账号
     */
    private String account;

    /**
     * 是否启用(1:是；0:否)
     */
    private String enabled;


}
