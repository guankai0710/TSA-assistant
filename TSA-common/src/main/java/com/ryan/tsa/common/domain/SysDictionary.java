package com.ryan.tsa.common.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统字典 
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tsa_sys_dictionary")
public class SysDictionary implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 系统字典id
     */
    @TableId(value = "sys_dic_id", type = IdType.AUTO)
    private Integer sysDicId;

    /**
     * 字典类型编码
     */
    @TableField("type_code")
    private String typeCode;

    /**
     * 字典类型名称
     */
    @TableField("type_name")
    private String typeName;

    /**
     * 字典值
     */
    @TableField("dic_value")
    private String dicValue;

    /**
     * 字典名称
     */
    @TableField("dic_name")
    private String dicName;

    /**
     * 字典备注
     */
    @TableField("dic_memo")
    private String dicMemo;

    /**
     * 创建人
     */
    @TableField("created_by")
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField(value = "created_time",fill = FieldFill.INSERT)
    private Date createdTime;

    /**
     * 更新人
     */
    @TableField("updated_by")
    private String updatedBy;

    /**
     * 更新时间
     */
    @TableField(value = "updated_time",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    /**
     * 是否删除(1:是；0:否)
     */
    @TableField("deleted")
    private Integer deleted;


}
