package com.ryan.tsa.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.ryan.tsa.auth.domain.Role;
import com.ryan.tsa.auth.mapper.RoleMapper;
import com.ryan.tsa.auth.qo.RoleQo;
import com.ryan.tsa.auth.service.RoleService;
import com.ryan.tsa.auth.vo.RoleVo;
import com.ryan.tsa.common.response.PageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Service
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageResponse<RoleVo> pageList(RoleQo qo) {
        PageHelper.startPage(qo.getPageNum(),qo.getPageSize());
        List<RoleVo> roleVos = roleMapper.queryList(qo);
        return PageResponse.of(roleVos);
    }
}
