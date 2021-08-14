package com.ryan.tsa.web.business.service.impl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryan.tsa.common.exception.BusinessException;
import com.ryan.tsa.common.response.PageResponse;
import com.ryan.tsa.common.response.ResultCode;
import com.ryan.tsa.web.business.domain.BusinessRecord;
import com.ryan.tsa.web.business.mapper.BusinessRecordMapper;
import com.ryan.tsa.web.business.qo.BusinessRecordQo;
import com.ryan.tsa.web.business.service.IBusinessRecordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 交易记录 服务实现类
 * </p>
 *
 * @author Ryan
 * @since 2021-08-14
 */
@Service
@Slf4j
public class BusinessRecordServiceImpl extends ServiceImpl<BusinessRecordMapper, BusinessRecord> implements IBusinessRecordService {

    @Override
    public PageResponse<BusinessRecord> pageList(BusinessRecordQo qo) {
        QueryWrapper<BusinessRecord> queryWrapper = new QueryWrapper<>();
        setQueryCondition(queryWrapper,qo);
        setOrderBy(queryWrapper,qo);
        Page<BusinessRecord> page = new Page<>(qo.getPageNum(), qo.getPageSize());
        return PageResponse.of(baseMapper.selectPage(page,queryWrapper));

    }

    /**
     * 设置查询条件
     *
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    private void setQueryCondition(QueryWrapper<BusinessRecord> queryWrapper, BusinessRecordQo qo){
        if (qo.getPersonId() != null){
            queryWrapper.lambda().eq(BusinessRecord::getPersonId,qo.getPersonId());
        }
        if (qo.getCustomerId() != null){
            queryWrapper.lambda().eq(BusinessRecord::getCustomerId,qo.getCustomerId());
        }
        if (qo.getStatus() != null){
            queryWrapper.lambda().eq(BusinessRecord::getStatus,qo.getStatus());
        }
        if (StringUtils.isBlank(qo.getBuyStartTime()) && StringUtils.isBlank(qo.getBuyEndTime())){
            queryWrapper.lambda().ge(BusinessRecord::getBuyTime,qo.getBuyStartTime());
            queryWrapper.lambda().le(BusinessRecord::getBuyTime,qo.getBuyEndTime());
        }
        if (StringUtils.isBlank(qo.getSellStartTime()) && StringUtils.isBlank(qo.getSellEndTime())){
            queryWrapper.lambda().ge(BusinessRecord::getSellTime,qo.getSellStartTime());
            queryWrapper.lambda().le(BusinessRecord::getSellTime,qo.getSellEndTime());
        }
        if (StringUtils.isNotBlank(qo.getStockNameOrStockCode())){
            queryWrapper.lambda()
                    .like(BusinessRecord::getStockName,qo.getStockNameOrStockCode()).or()
                    .like(BusinessRecord::getStockCode,qo.getStockNameOrStockCode());
        }
    }

    /**
     * 设置排序
     *
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    private void setOrderBy(QueryWrapper<BusinessRecord> queryWrapper, BusinessRecordQo qo){
        try {
            if (StringUtils.isNotBlank(qo.getOrder())){
                queryWrapper.orderBy(true,qo.getSort(),
                        BusinessRecord.class.getDeclaredField(qo.getOrder()).getAnnotation(TableField.class).value());
            } else {
                queryWrapper.lambda().orderByDesc(BusinessRecord::getCreatedTime);
            }
        } catch (NoSuchFieldException e) {
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }
}
