package com.ryan.tsa.common.service.impl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ryan.tsa.common.domain.SysDictionary;
import com.ryan.tsa.common.domain.SysParameter;
import com.ryan.tsa.common.exception.BusinessException;
import com.ryan.tsa.common.mapper.SysParameterMapper;
import com.ryan.tsa.common.qo.SysParameterQo;
import com.ryan.tsa.common.response.PageResponse;
import com.ryan.tsa.common.response.ResultCode;
import com.ryan.tsa.common.service.ISysParameterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统参数 服务实现类
 * </p>
 *
 * @author ryan
 * @since 2021-08-12
 */
@Service
@Slf4j
public class SysParameterServiceImpl extends ServiceImpl<SysParameterMapper, SysParameter> implements ISysParameterService {

    private static final String PARAM_FORMAT = "0000";

    @Override
    public PageResponse<SysParameter> pageList(SysParameterQo qo) {
        try {
            QueryWrapper<SysParameter> queryWrapper = new QueryWrapper<>();
            if (StringUtils.isNotBlank(qo.getParamCodeOrParamName())){
                queryWrapper.lambda()
                        .like(SysParameter::getParamCode,qo.getParamCodeOrParamName()).or()
                        .like(SysParameter::getParamName,qo.getParamCodeOrParamName());
            }
            if (StringUtils.isNotBlank(qo.getOrder())){
                queryWrapper.orderBy(true,qo.getSort(),
                        SysParameter.class.getDeclaredField(qo.getOrder()).getAnnotation(TableField.class).value());
            } else {
                queryWrapper.lambda().orderByDesc(SysParameter::getCreatedTime);
            }
            Page<SysParameter> page = new Page<>(qo.getPageNum(),qo.getPageSize());
            return PageResponse.of(baseMapper.selectPage(page, queryWrapper));
        } catch (NoSuchFieldException e) {
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public boolean save(SysParameter sysParameter) {
        try {
            if (StringUtils.isBlank(sysParameter.getParamCode()) || StringUtils.isBlank(sysParameter.getParamName()) ||
                    StringUtils.isBlank(sysParameter.getParamValue())){
                throw new BusinessException(ResultCode.PARAM_NOT_EXIST);
            }
            Integer newestParamCode = getNewestParamCode();
            String paramCode = PARAM_FORMAT;
            if (newestParamCode != null){
                paramCode = PARAM_FORMAT + paramCode;
                paramCode = paramCode.substring(paramCode.length());
            }
            sysParameter.setParamCode(paramCode);
            baseMapper.insert(sysParameter);
            return true;
        } catch (BusinessException e) {
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public boolean updateById(SysParameter sysParameter) {
        try {
            if (sysParameter.getSyaParamId() == null){
                throw new BusinessException(ResultCode.PARAM_NOT_EXIST);
            }
            baseMapper.updateById(sysParameter);
            return true;
        } catch (BusinessException e) {
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public String getParamValueByParamCode(String paramCode) {
        return baseMapper.getParamValueByParamCode(paramCode);
    }

    /**
     * 获取最新的参数编码
     *
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    public Integer getNewestParamCode(){
        LambdaQueryWrapper<SysParameter> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(SysParameter::getCreatedTime);
        SysParameter sysParameter = baseMapper.selectOne(queryWrapper);
        return sysParameter == null ? null : Integer.valueOf(sysParameter.getParamCode());
    }
}
