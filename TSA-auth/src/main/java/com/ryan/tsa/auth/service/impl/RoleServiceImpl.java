package com.ryan.tsa.auth.service.impl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryan.tsa.auth.domain.Role;
import com.ryan.tsa.auth.mapper.RoleMapper;
import com.ryan.tsa.auth.qo.RoleQo;
import com.ryan.tsa.auth.service.IRoleService;
import com.ryan.tsa.common.exception.BusinessException;
import com.ryan.tsa.common.response.PageResponse;
import com.ryan.tsa.common.response.ResultCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    @Override
    public PageResponse<Role> pageList(RoleQo qo) {
        try {
            QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
            if (StringUtils.isNotBlank(qo.getName())){
                queryWrapper.lambda().like(Role::getName,qo.getName());
            }
            if (StringUtils.isNotBlank(qo.getOrder())){
                queryWrapper.orderBy(true,qo.getSort(),
                        Role.class.getDeclaredField(qo.getOrder()).getAnnotation(TableField.class).value());
            } else {
                queryWrapper.lambda().orderByDesc(Role::getCreatedTime);
            }
            Page<Role> page = new Page<>(qo.getPageNum(), qo.getPageSize());
            return PageResponse.of(baseMapper.selectPage(page,queryWrapper));
        } catch (NoSuchFieldException e) {
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public List<Map<String, Object>> dropDownList() {
        return baseMapper.dropDownList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(Role role) {
        try {
            if (role.getRoleId() == null || StringUtils.isBlank(role.getName())){
                throw new BusinessException(ResultCode.PARAM_NOT_EXIST);
            }
            baseMapper.insert(role);
            return true;
        } catch (BusinessException e) {
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(Role role) {
        try {
            if (role.getRoleId() == null){
                throw new BusinessException(ResultCode.PARAM_NOT_EXIST);
            }
            baseMapper.updateById(role);
            return true;
        } catch (BusinessException e) {
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }
}
