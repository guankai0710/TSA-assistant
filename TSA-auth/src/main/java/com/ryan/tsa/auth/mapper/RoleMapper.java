package com.ryan.tsa.auth.mapper;

import com.ryan.tsa.auth.domain.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author ryan
 * @since 2021-04-23
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getList();
}
