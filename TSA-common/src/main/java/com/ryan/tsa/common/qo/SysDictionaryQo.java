package com.ryan.tsa.common.qo;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 系统字典 
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Data
public class SysDictionaryQo extends BaseQo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 字典类型编码/字典名称
     */
    private String typeCodeOrDicName;

}
