package com.ryan.tsa.auth.service.impl;

import com.ryan.tsa.auth.domain.Role;
import com.ryan.tsa.auth.mapper.RoleMapper;
import com.ryan.tsa.auth.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author ryan
 * @since 2021-04-23
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
