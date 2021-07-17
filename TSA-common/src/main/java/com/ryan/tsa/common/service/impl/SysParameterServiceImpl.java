package com.ryan.tsa.common.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.ryan.tsa.common.domain.SysParameter;
import com.ryan.tsa.common.exception.BusinessException;
import com.ryan.tsa.common.mapper.SysParameterMapper;
import com.ryan.tsa.common.qo.SysParameterQo;
import com.ryan.tsa.common.response.PageResponse;
import com.ryan.tsa.common.response.ResultCode;
import com.ryan.tsa.common.service.SysParameterService;
import com.ryan.tsa.common.vo.SysParameterVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 系统参数  服务实现类
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Service
@Slf4j
public class SysParameterServiceImpl extends ServiceImpl<SysParameterMapper, SysParameter> implements SysParameterService {

    @Autowired
    private SysParameterMapper sysParameterMapper;

    @Override
    public PageResponse<SysParameterVo> pageList(SysParameterQo qo) {
        PageHelper.startPage(qo.getPageNum(),qo.getPageSize(),"updated_time desc");
        List<SysParameterVo> sysParameterVos = sysParameterMapper.queryList(qo);
        return PageResponse.of(sysParameterVos);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean save(String json) {
        SysParameter sysParameter = JSON.parseObject(json, SysParameter.class);
        //参数校验
        if (StringUtils.isBlank(sysParameter.getParamCode()) || StringUtils.isBlank(sysParameter.getParamName())
                || StringUtils.isBlank(sysParameter.getParamValue())){
            throw new BusinessException(ResultCode.PARAM_NOT_EXIST);
        }
        try {
            sysParameter.setDeleted(0);
            sysParameterMapper.insert(sysParameter);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return false;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean update(String json) {
        SysParameter sysParameter = JSON.parseObject(json, SysParameter.class);
        //参数校验
        if (sysParameter.getSyaParamId() == null){
            throw new BusinessException(ResultCode.PARAM_NOT_EXIST);
        }
        try {
            sysParameterMapper.updateById(sysParameter);
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
            sysParameterMapper.delete(ids);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return false;
        }
    }

    @Override
    public SysParameterVo getByParamCode(String paramCode) {
        return sysParameterMapper.getByParamCode(paramCode);
    }
}
