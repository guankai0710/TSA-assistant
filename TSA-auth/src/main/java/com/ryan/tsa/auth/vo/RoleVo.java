package com.ryan.tsa.auth.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(callSuper = false)
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
