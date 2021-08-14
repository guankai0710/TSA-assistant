package com.ryan.tsa.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
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
