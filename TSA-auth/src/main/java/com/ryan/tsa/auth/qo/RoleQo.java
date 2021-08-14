package com.ryan.tsa.auth.qo;

import com.ryan.tsa.common.qo.BaseQo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 角色信息
 * </p>
 *
 * @author Ryan
 * @since 2021-08-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class RoleQo extends BaseQo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 角色名称
     */
    private String name;

    public RoleQo(Integer pageNum, Integer pageSize, String order, Boolean sort, String name) {
        super(pageNum, pageSize, order, sort);
        this.name = name;
    }
}
