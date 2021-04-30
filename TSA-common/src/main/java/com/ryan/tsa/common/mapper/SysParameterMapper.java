package com.ryan.tsa.common.mapper;

import com.ryan.tsa.common.domain.SysParameter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ryan.tsa.common.vo.SysParameterVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统参数  Mapper 接口
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Repository
@Mapper
public interface SysParameterMapper extends BaseMapper<SysParameter> {

    /**
     * 根据参数编码查询
     *
     * @param paramCode 参数编码
     * @author guankai
     * @date 2021/4/30
     * @return
     **/
    SysParameterVo getByParamCode(@Param("paramCode") String paramCode);

}
