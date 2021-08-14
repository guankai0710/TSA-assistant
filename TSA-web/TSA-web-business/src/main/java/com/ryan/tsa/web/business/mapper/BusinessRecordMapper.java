package com.ryan.tsa.web.business.mapper;

import com.ryan.tsa.web.business.domain.BusinessRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 交易记录 Mapper 接口
 * </p>
 *
 * @author Ryan
 * @since 2021-08-14
 */
@Mapper
@Repository
public interface BusinessRecordMapper extends BaseMapper<BusinessRecord> {

}
