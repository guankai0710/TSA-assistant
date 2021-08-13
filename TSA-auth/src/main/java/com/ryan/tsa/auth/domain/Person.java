package com.ryan.tsa.auth.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@TableName("tsa_auth_person")
public class Person implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户id
     */
    @TableId(value = "person_id", type = IdType.AUTO)
    private Integer personId;

    /**
     * 角色id
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 用户名称
     */
    @TableField("name")
    private String name;

    /**
     * 账号
     */
    @TableField("account")
    private String account;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 加密盐
     */
    @TableField("encryptsalt")
    private String encryptsalt;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 性别(1:男；2:女)
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 电话
     */
    @TableField("pthone")
    private String pthone;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 地址
     */
    @TableField("addr")
    private String addr;

    /**
     * 是否在线(1:是；0:否)
     */
    @TableField("onlined")
    private Integer onlined;

    /**
     * 是否启用(1:是；0:否)
     */
    @TableField("enabled")
    private Integer enabled;

    /**
     * 创建时间
     */
    @TableField(value = "created_time",fill = FieldFill.INSERT)
    private String createdTime;

    /**
     * 更新时间
     */
    @TableField(value = "updated_time",fill = FieldFill.INSERT_UPDATE)
    private String updatedTime;


}
