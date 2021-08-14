package com.ryan.tsa.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ryan.tsa.common.domain.SysParameter;
import com.ryan.tsa.common.qo.SysParameterQo;
import com.ryan.tsa.common.response.PageResponse;

/**
 * <p>
 * 系统参数 服务类
 * </p>
 *
 * @author ryan
 * @since 2021-08-12
 */
public interface ISysParameterService extends IService<SysParameter> {

    /**
     * 分页查询
     *
     * @param qo 查询条件
     * @author Ryan
     * @date 2021/8/13
     * @return
     **/
    PageResponse<SysParameter> pageList(SysParameterQo qo);

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
