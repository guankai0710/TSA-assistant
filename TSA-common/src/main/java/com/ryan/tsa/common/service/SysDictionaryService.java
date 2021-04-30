package com.ryan.tsa.common.service;

import com.ryan.tsa.common.domain.SysDictionary;
import com.baomidou.mybatisplus.extension.service.IService;
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
     * 根据字典类型编码获取字典值
     *
     * @param typeCode 字典类型编码
     * @author guankai
     * @date 2021/4/30
     * @return
     **/
    List<SysDictionaryVo> getByTypeCode(String typeCode);

}
