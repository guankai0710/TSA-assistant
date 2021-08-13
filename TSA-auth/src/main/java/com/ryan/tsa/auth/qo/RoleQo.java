package com.ryan.tsa.auth.qo;

import com.ryan.tsa.common.qo.BaseQo;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 角色信息
 * </p>
 *
 * @author Ryan
 * @since 2021-08-13
 */
@Data
public class RoleQo extends BaseQo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 角色名称
     */
    private String name;

}
