package com.ryan.tsa.web.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ryan.tsa.common.response.PageResponse;
import com.ryan.tsa.web.business.domain.BusinessRecord;
import com.ryan.tsa.web.business.qo.BusinessRecordQo;

/**
 * <p>
 * 交易记录 服务类
 * </p>
 *
 * @author Ryan
 * @since 2021-08-14
 */
public interface IBusinessRecordService extends IService<BusinessRecord> {

    /**
     * 分页查询
     *
     * @param qo 查询条件
     * @author Ryan
     * @date 2021/8/13
     * @return
     **/
    PageResponse<BusinessRecord> pageList(BusinessRecordQo qo);

}
