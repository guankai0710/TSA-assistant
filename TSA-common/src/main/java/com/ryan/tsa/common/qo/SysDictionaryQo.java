package com.ryan.tsa.common.qo;

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
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class SysDictionaryQo extends BaseQo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 字典类型编码/字典类型名称
     */
    private String typeCodeOrTypeName;

    public SysDictionaryQo(Integer pageNum, Integer pageSize, String order, Boolean sort, String typeCodeOrTypeName) {
        super(pageNum, pageSize, order, sort);
        this.typeCodeOrTypeName = typeCodeOrTypeName;
    }
}
