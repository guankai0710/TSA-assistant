package com.ryan.tsa.auth.qo;

import com.ryan.tsa.common.qo.BaseQo;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author ryan
 * @since 2021-04-23
 */
@Data
public class RoleQo extends BaseQo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 角色名称
     */
    private String name;

}
