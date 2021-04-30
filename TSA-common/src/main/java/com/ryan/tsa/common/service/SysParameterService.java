package com.ryan.tsa.common.service;

import com.ryan.tsa.common.domain.SysParameter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ryan.tsa.common.vo.SysParameterVo;

/**
 * <p>
 * 系统参数  服务类
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
public interface SysParameterService extends IService<SysParameter> {

    /**
     * 根据参数编码查询
     *
     * @param paramCode 参数编码
     * @author guankai
     * @date 2021/4/30
     * @return
     **/
    SysParameterVo getByParamCode(String paramCode);

}
