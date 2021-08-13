package com.ryan.tsa.auth.mapper;

import com.ryan.tsa.auth.domain.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author Ryan
 * @since 2021-08-13
 */
@Mapper
@Repository
public interface PersonMapper extends BaseMapper<Person> {

}
