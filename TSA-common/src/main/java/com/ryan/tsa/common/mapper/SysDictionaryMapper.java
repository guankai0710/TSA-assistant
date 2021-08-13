package com.ryan.tsa.common.mapper;

import com.ryan.tsa.common.domain.SysDictionary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统字典 Mapper 接口
 * </p>
 *
 * @author ryan
 * @since 2021-08-12
 */
@Mapper
@Repository
public interface SysDictionaryMapper extends BaseMapper<SysDictionary> {

}
