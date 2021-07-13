package com.ryan.tsa.common.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统参数 
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tsa_sys_parameter")
public class SysParameter implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 系统参数id
     */
    @TableId(value = "sya_param_id", type = IdType.AUTO)
    private Integer syaParamId;

    /**
     * 系统参数编码
     */
    @TableField("param_code")
    private String paramCode;

    /**
     * 系统参数名称
     */
    @TableField("param_name")
    private String paramName;

    /**
     * 系统参数值
     */
    @TableField("param_value")
    private String paramValue;

    /**
     * 系统参数备注
     */
    @TableField("memo")
    private String memo;

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

    /**
     * 是否删除(1:是；0:否)
     */
    @TableField("deleted")
    private Integer deleted;


}
