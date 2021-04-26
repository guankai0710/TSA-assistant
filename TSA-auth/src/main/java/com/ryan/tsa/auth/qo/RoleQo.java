package com.ryan.tsa.auth.qo;

import com.ryan.tsa.common.qo.BaseQo;
import lombok.Data;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author ryan
 * @since 2021-04-23
 */
@Data
public class RoleQo extends BaseQo {

    /**
     * 角色名称
     */
    private String roleName;

}
