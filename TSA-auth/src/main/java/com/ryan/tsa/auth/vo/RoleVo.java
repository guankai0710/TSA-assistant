package com.ryan.tsa.auth.vo;

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
public class RoleVo {

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 备注
     */
    private String roleMemo;


}
