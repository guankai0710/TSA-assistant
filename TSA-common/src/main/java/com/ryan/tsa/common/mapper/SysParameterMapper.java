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


    /**
     * 根据系统参数编码查询系统参数值
     *
     * @param paramCode 系统参数编码
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    String getParamValueByParamCode(String paramCode);

}
