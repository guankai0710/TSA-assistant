package com.ryan.tsa.auth.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author ryan
 * @since 2021-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tsa_auth_role")
public class Role implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 角色id
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 备注
     */
    @TableField("role_memo")
    private String roleMemo;

    /**
     * 是否删除(1:是；0:否)
     */
    @TableField("deleted")
    private String deleted;

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
