package com.ryan.tsa.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ryan.tsa.common.domain.SysDictionary;
import com.ryan.tsa.common.qo.SysDictionaryQo;
import com.ryan.tsa.common.response.PageResponse;

import java.util.List;

/**
 * <p>
 * 系统字典 服务类
 * </p>
 *
 * @author ryan
 * @since 2021-08-12
 */
public interface ISysDictionaryService extends IService<SysDictionary> {

    /**
     * 分页查询
     *
     * @param qo 查询条件
     * @author Ryan
     * @date 2021/8/13
     * @return
     **/
    PageResponse<SysDictionary> pageList(SysDictionaryQo qo);

    /**
     * 根据字典类型编码查询
     *
     * @param typeCode 字典类型编码
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    List<SysDictionary> getByTypeCode(String typeCode);

}
