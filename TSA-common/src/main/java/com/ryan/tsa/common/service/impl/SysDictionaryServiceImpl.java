package com.ryan.tsa.common.service.impl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ryan.tsa.common.domain.SysDictionary;
import com.ryan.tsa.common.exception.BusinessException;
import com.ryan.tsa.common.mapper.SysDictionaryMapper;
import com.ryan.tsa.common.qo.SysDictionaryQo;
import com.ryan.tsa.common.response.PageResponse;
import com.ryan.tsa.common.response.ResultCode;
import com.ryan.tsa.common.service.ISysDictionaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Predicate;

/**
 * <p>
 * 系统字典 服务实现类
 * </p>
 *
 * @author ryan
 * @since 2021-08-12
 */
@Service
@Slf4j
public class SysDictionaryServiceImpl extends ServiceImpl<SysDictionaryMapper, SysDictionary> implements ISysDictionaryService {

    @Override
    public PageResponse<SysDictionary> pageList(SysDictionaryQo qo) {
        try {
            QueryWrapper<SysDictionary> queryWrapper = new QueryWrapper<>();
            if (StringUtils.isNotBlank(qo.getTypeCodeOrTypeName())){
                queryWrapper.lambda()
                        .like(SysDictionary::getTypeCode,qo.getTypeCodeOrTypeName()).or()
                        .like(SysDictionary::getTypeName,qo.getTypeCodeOrTypeName());
            }
            if (StringUtils.isNotBlank(qo.getOrder())){
                queryWrapper.orderBy(true,qo.getSort(),
                        SysDictionary.class.getDeclaredField(qo.getOrder()).getAnnotation(TableField.class).value());
            } else {
                queryWrapper.lambda().orderByDesc(SysDictionary::getCreatedTime);
            }
            Page<SysDictionary> page = new Page<>(qo.getPageNum(),qo.getPageSize());
            return PageResponse.of(baseMapper.selectPage(page, queryWrapper));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }
}
