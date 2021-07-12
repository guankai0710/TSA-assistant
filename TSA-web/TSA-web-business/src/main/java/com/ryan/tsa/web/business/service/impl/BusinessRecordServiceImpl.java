package com.ryan.tsa.web.business.service.impl;

import com.ryan.tsa.web.business.domain.BusinessRecord;
import com.ryan.tsa.web.business.mapper.BusinessRecordMapper;
import com.ryan.tsa.web.business.service.BusinessRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 交易记录  服务实现类
 * </p>
 *
 * @author ryan
 * @since 2021-07-12
 */
@Service
public class BusinessRecordServiceImpl extends ServiceImpl<BusinessRecordMapper, BusinessRecord> implements BusinessRecordService {

}
