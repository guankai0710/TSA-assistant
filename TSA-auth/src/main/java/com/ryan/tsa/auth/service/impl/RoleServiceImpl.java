package com.ryan.tsa.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.ryan.tsa.auth.domain.Role;
import com.ryan.tsa.auth.mapper.RoleMapper;
import com.ryan.tsa.auth.service.RoleService;
import com.ryan.tsa.common.vo.PageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private RoleMapper roleMapper;

    @Override
    public PageVo<Role> page(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Role> list = roleMapper.getList();
//        List<Role> list = list();
        return PageVo.of(list);
    }
}
