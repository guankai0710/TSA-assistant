package com.ryan.tsa.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 系统参数
 * </p>
 *
 * @author ryan
 * @since 2021-08-12
 */
@Data
public class SysParameterVo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 系统参数id
     */
    private Integer syaParamId;

    /**
     * 系统参数编码
     */
    private String paramCode;

    /**
     * 系统参数名称
     */
    private String paramName;

    /**
     * 系统参数值
     */
    private String paramValue;

    /**
     * 系统参数备注
     */
    private String memo;

}
