package com.ryan.tsa.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.ryan.tsa.auth.domain.Role;
import com.ryan.tsa.auth.mapper.RoleMapper;
import com.ryan.tsa.auth.qo.RoleQo;
import com.ryan.tsa.auth.service.RoleService;
import com.ryan.tsa.auth.vo.RoleVo;
import com.ryan.tsa.common.exception.BusinessException;
import com.ryan.tsa.common.response.PageResponse;
import com.ryan.tsa.common.response.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        PageHelper.startPage(qo.getPageNum(),qo.getPageSize(),"updated_time desc");
        List<RoleVo> roleVos = roleMapper.queryList(qo);
        return PageResponse.of(roleVos);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean save(String json) {
        Role role = JSON.parseObject(json, Role.class);
        if (StringUtils.isBlank(role.getName())){
            throw new BusinessException(ResultCode.PARAM_NOT_EXIST);
        }
        try {
            role.setDeleted(0);
            roleMapper.insert(role);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return false;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean update(String json) {
        Role role = JSON.parseObject(json, Role.class);
        if (role.getRoleId() == null){
            throw new BusinessException(ResultCode.PARAM_NOT_EXIST);
        }
        try {
            roleMapper.updateById(role);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return false;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean delete(String ids) {
        try {
            roleMapper.delete(ids);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return false;
        }
    }
}
