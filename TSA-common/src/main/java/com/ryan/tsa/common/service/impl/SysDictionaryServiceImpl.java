package com.ryan.tsa.common.service.impl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryan.tsa.common.domain.SysDictionary;
import com.ryan.tsa.common.exception.BusinessException;
import com.ryan.tsa.common.mapper.SysDictionaryMapper;
import com.ryan.tsa.common.qo.SysDictionaryQo;
import com.ryan.tsa.common.response.PageResponse;
import com.ryan.tsa.common.response.ResultCode;
import com.ryan.tsa.common.service.ISysDictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        QueryWrapper<SysDictionary> queryWrapper = new QueryWrapper<>();
        setQueryCondition(queryWrapper,qo);
        setOrderBy(queryWrapper,qo);
        Page<SysDictionary> page = new Page<>(qo.getPageNum(),qo.getPageSize());
        return PageResponse.of(baseMapper.selectPage(page, queryWrapper));
    }

    /**
     * 设置查询条件
     *
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    private void setQueryCondition(QueryWrapper<SysDictionary> queryWrapper, SysDictionaryQo qo){
        if (StringUtils.isNotBlank(qo.getTypeCodeOrTypeName())){
            queryWrapper.lambda()
                    .like(SysDictionary::getTypeCode,qo.getTypeCodeOrTypeName()).or()
                    .like(SysDictionary::getTypeName,qo.getTypeCodeOrTypeName());
        }
    }

    /**
     * 设置排序
     *
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    private void setOrderBy(QueryWrapper<SysDictionary> queryWrapper, SysDictionaryQo qo){
        try {
            if (StringUtils.isNotBlank(qo.getOrder())){
                queryWrapper.orderBy(true,qo.getSort(),
                        SysDictionary.class.getDeclaredField(qo.getOrder()).getAnnotation(TableField.class).value());
            } else {
                queryWrapper.lambda().orderByDesc(SysDictionary::getCreatedTime);
            }
        } catch (NoSuchFieldException e) {
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public boolean updateById(SysDictionary sysDictionary) {
        try {
            if (sysDictionary.getSysDicId() == null ||
                    StringUtils.isBlank(sysDictionary.getTypeCode()) || StringUtils.isBlank(sysDictionary.getTypeName()) ||
                    StringUtils.isBlank(sysDictionary.getDicValue()) || StringUtils.isBlank(sysDictionary.getDicName())){
                throw new BusinessException(ResultCode.PARAM_NOT_EXIST);
            }
            if (checkDicIsExist(sysDictionary.getTypeCode(), sysDictionary.getDicValue())) {
                throw new BusinessException(ResultCode.PARAM_IS_ERROR);
            }
            baseMapper.updateById(sysDictionary);
            return true;
        } catch (BusinessException e) {
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(SysDictionary sysDictionary) {
        try {
            if (StringUtils.isBlank(sysDictionary.getTypeCode()) || StringUtils.isBlank(sysDictionary.getTypeName()) ||
                    StringUtils.isBlank(sysDictionary.getDicValue()) || StringUtils.isBlank(sysDictionary.getDicName())){
                throw new BusinessException(ResultCode.PARAM_NOT_EXIST);
            }
            if (checkDicIsExist(sysDictionary.getTypeCode(), sysDictionary.getDicValue())) {
                throw new BusinessException(ResultCode.PARAM_IS_ERROR);
            }
            baseMapper.insert(sysDictionary);
            return true;
        } catch (BusinessException e) {
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public List<SysDictionary> getByTypeCode(String typeCode) {
        LambdaQueryWrapper<SysDictionary> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysDictionary::getTypeCode,typeCode);
        return baseMapper.selectList(queryWrapper);
    }

    /**
     * 校验字典是否已存在
     *
     * @param typeCode 字典类型编码
     * @param dicValue 字典值
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    private boolean checkDicIsExist(String typeCode, String dicValue){
        LambdaQueryWrapper<SysDictionary> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysDictionary::getTypeCode,typeCode).eq(SysDictionary::getDicValue,dicValue);
        Integer count = baseMapper.selectCount(queryWrapper);
        return count > 0;
    }
}
