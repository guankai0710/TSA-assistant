package com.ryan.tsa.auth.vo;

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
public class RoleVo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 备注
     */
    private String memo;


}
