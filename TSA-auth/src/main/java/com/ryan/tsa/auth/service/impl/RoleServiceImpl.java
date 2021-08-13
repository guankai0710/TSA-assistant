package com.ryan.tsa.auth.service.impl;

import com.ryan.tsa.auth.domain.Role;
import com.ryan.tsa.auth.mapper.RoleMapper;
import com.ryan.tsa.auth.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息 服务实现类
 * </p>
 *
 * @author Ryan
 * @since 2021-08-13
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
