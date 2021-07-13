package com.ryan.tsa.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ryan.tsa.common.domain.SysParameter;
import com.ryan.tsa.common.qo.SysParameterQo;
import com.ryan.tsa.common.response.PageResponse;
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
     * 分页查询列表
     *
     * @param qo 查询条件
     * @author ryan
     * @date 2021/7/13
     * @return
     **/
    PageResponse<SysParameterVo> pageList(SysParameterQo qo);

    /**
     * 新增
     *
     * @param json 系统字典json字符串
     * @author ryan
     * @date 2021/7/13
     * @return
     **/
    Boolean save(String json);

    /**
     * 修改
     *
     * @param json 系统字典json字符串
     * @author ryan
     * @date 2021/7/13
     * @return
     **/
    Boolean update(String json);

    /**
     * 批量删除
     *
     * @param ids 主键ids
     * @author ryan
     * @date 2021/7/13
     * @return
     **/
    Boolean delete(String ids);

    /**
     * 根据参数编码查询
     *
     * @param paramCode 参数编码
     * @author ryan
     * @date 2021/4/30
     * @return
     **/
    SysParameterVo getByParamCode(String paramCode);

}
