package com.ryan.tsa.auth.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户 
 * </p>
 *
 * @author ryan
 * @since 2021-04-23
 */
@Data
public class PersonVo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户id
     */
    private Integer personId;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 账号
     */
    private String account;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别(1:男；2:女)
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 电话
     */
    private String pthone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String addr;

    /**
     * 是否在线(1:是；0:否)
     */
    private Integer onlined;

    /**
     * 是否启用(1:是；0:否)
     */
    private Integer enabled;

}
