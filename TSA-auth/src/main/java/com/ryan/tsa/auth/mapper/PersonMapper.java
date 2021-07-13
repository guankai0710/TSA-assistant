package com.ryan.tsa.auth.mapper;

import com.ryan.tsa.auth.domain.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ryan.tsa.auth.qo.PersonQo;
import com.ryan.tsa.auth.vo.PersonVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户  Mapper 接口
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Repository
@Mapper
public interface PersonMapper extends BaseMapper<Person> {

    /**
     * 分页查询
     *
     * @param qo 查询条件
     * @author guankai
     * @date 2021/4/30
     * @return
     **/
    List<PersonVo> queryList(PersonQo qo);

    /**
     * 修改在线状态
     *
     * @param personId 用户id
     * @param onlined 是否在线
     * @author ryan
     * @date 2021/4/29
     * @return
     **/
    void updateOnlined(@Param("personId") Integer personId, @Param("onlined") Integer onlined);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    void delete(@Param("ids") String ids);

}
