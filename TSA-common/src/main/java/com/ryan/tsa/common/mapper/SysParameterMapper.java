package com.ryan.tsa.common.mapper;

import com.ryan.tsa.common.domain.SysParameter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统参数 Mapper 接口
 * </p>
 *
 * @author ryan
 * @since 2021-08-12
 */
@Mapper
@Repository
public interface SysParameterMapper extends BaseMapper<SysParameter> {

}
