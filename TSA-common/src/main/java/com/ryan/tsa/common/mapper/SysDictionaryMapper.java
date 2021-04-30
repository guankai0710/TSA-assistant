package com.ryan.tsa.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ryan.tsa.common.domain.SysDictionary;
import com.ryan.tsa.common.vo.SysDictionaryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 系统字典  Mapper 接口
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Repository
@Mapper
public interface SysDictionaryMapper extends BaseMapper<SysDictionary> {

    /**
     * 根据字典类型编码获取字典值
     *
     * @param typeCode 字典类型编码
     * @author guankai
     * @date 2021/4/30
     * @return
     **/
    List<SysDictionaryVo> getByTypeCode(@Param("typeCode") String typeCode);

}
