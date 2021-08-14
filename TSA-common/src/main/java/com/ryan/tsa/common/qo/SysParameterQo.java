package com.ryan.tsa.common.qo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class SysParameterQo extends BaseQo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 系统参数编码/系统参数名称
     */
    private String paramCodeOrParamName;

    public SysParameterQo(Integer pageNum, Integer pageSize, String order, Boolean sort, String paramCodeOrParamName) {
        super(pageNum, pageSize, order, sort);
        this.paramCodeOrParamName = paramCodeOrParamName;
    }
}
