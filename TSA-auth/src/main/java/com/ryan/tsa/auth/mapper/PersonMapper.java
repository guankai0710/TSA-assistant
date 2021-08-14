package com.ryan.tsa.auth.mapper;

import com.ryan.tsa.auth.domain.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    /**
     * 用户下拉列表
     *
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    List<Map<String,Object>> dropDownList();

}
