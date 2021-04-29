package com.ryan.tsa.common.service.impl;

import com.ryan.tsa.common.domain.SysParameter;
import com.ryan.tsa.common.mapper.SysParameterMapper;
import com.ryan.tsa.common.service.SysParameterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

}