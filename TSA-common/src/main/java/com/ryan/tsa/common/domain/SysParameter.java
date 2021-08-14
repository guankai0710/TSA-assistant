package com.ryan.tsa.common.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 系统参数
 * </p>
 *
 * @author ryan
 * @since 2021-08-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
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


}
