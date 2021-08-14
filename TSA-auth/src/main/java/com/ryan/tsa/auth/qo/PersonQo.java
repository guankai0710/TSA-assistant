package com.ryan.tsa.auth.qo;

import com.ryan.tsa.common.qo.BaseQo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author Ryan
 * @since 2021-08-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PersonQo extends BaseQo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 用户名称/账号
     */
    private String nameOrAccount;

    /**
     * 是否在线(1:是；0:否)
     */
    private Integer onlined;

    /**
     * 是否启用(1:是；0:否)
     */
    private Integer enabled;

}
