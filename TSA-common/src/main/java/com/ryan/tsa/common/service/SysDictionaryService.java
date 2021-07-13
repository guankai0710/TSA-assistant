package com.ryan.tsa.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ryan.tsa.common.domain.SysDictionary;
import com.ryan.tsa.common.qo.SysDictionaryQo;
import com.ryan.tsa.common.response.PageResponse;
import com.ryan.tsa.common.vo.SysDictionaryVo;

import java.util.List;

/**
 * <p>
 * 系统字典  服务类
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
public interface SysDictionaryService extends IService<SysDictionary> {

    /**
     * 分页查询列表
     *
     * @param qo 查询条件
     * @author ryan
     * @date 2021/7/13
     * @return
     **/
    PageResponse<SysDictionaryVo> pageList(SysDictionaryQo qo);

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
     * 根据字典类型编码获取字典值
     *
     * @param typeCode 字典类型编码
     * @author guankai
     * @date 2021/4/30
     * @return
     **/
    List<SysDictionaryVo> getByTypeCode(String typeCode);

}
