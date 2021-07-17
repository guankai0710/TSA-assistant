package com.ryan.tsa.common.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.ryan.tsa.common.domain.SysDictionary;
import com.ryan.tsa.common.exception.BusinessException;
import com.ryan.tsa.common.mapper.SysDictionaryMapper;
import com.ryan.tsa.common.qo.SysDictionaryQo;
import com.ryan.tsa.common.response.PageResponse;
import com.ryan.tsa.common.response.ResultCode;
import com.ryan.tsa.common.service.SysDictionaryService;
import com.ryan.tsa.common.vo.SysDictionaryVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 系统字典  服务实现类
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Service
@Slf4j
public class SysDictionaryServiceImpl extends ServiceImpl<SysDictionaryMapper, SysDictionary> implements SysDictionaryService {

    @Autowired
    private SysDictionaryMapper sysDictionaryMapper;

    @Override
    public PageResponse<SysDictionaryVo> pageList(SysDictionaryQo qo) {
        PageHelper.startPage(qo.getPageNum(),qo.getPageSize(),"updated_time desc");
        List<SysDictionaryVo> sysDictionaryVos = sysDictionaryMapper.queryList(qo);
        return PageResponse.of(sysDictionaryVos);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean save(String json) {
        SysDictionary sysDictionary = JSON.parseObject(json, SysDictionary.class);
        //参数校验
        if (StringUtils.isBlank(sysDictionary.getTypeCode()) || StringUtils.isBlank(sysDictionary.getTypeName())
            || StringUtils.isBlank(sysDictionary.getDicValue()) || StringUtils.isBlank(sysDictionary.getDicName())){
            throw new BusinessException(ResultCode.PARAM_NOT_EXIST);
        }
        try {
            sysDictionary.setDeleted(0);
            sysDictionaryMapper.insert(sysDictionary);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return false;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean update(String json) {
        SysDictionary sysDictionary = JSON.parseObject(json, SysDictionary.class);
        //参数校验
        if (sysDictionary.getSysDicId() == null){
            throw new BusinessException(ResultCode.PARAM_NOT_EXIST);
        }
        try {
            sysDictionaryMapper.updateById(sysDictionary);
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
            sysDictionaryMapper.delete(ids);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return false;
        }
    }

    @Override
    public List<SysDictionaryVo> getByTypeCode(String typeCode) {
        return Optional.ofNullable(sysDictionaryMapper.getByTypeCode(typeCode)).orElse(new ArrayList<>());
    }
}
