package com.ryan.tsa.common.qo;

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
public class SysParameterQo extends BaseQo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 系统参数编码/系统参数名称
     */
    private String paramCodeOrParamName;

}
