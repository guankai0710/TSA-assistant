package com.ryan.tsa.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 系统字典
 * </p>
 *
 * @author ryan
 * @since 2021-08-12
 */
@Data
public class SysDictionaryVo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 系统字典id
     */
    private Integer sysDicId;

    /**
     * 字典类型编码
     */
    private String typeCode;

    /**
     * 字典类型名称
     */
    private String typeName;

    /**
     * 字典值
     */
    private String dicValue;

    /**
     * 字典名称
     */
    private String dicName;

    /**
     * 字典备注
     */
    private String dicMemo;


}
