package com.ryan.tsa.web.business.service.impl;

import com.ryan.tsa.web.business.domain.BusinessRecord;
import com.ryan.tsa.web.business.mapper.BusinessRecordMapper;
import com.ryan.tsa.web.business.service.IBusinessRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
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

}
