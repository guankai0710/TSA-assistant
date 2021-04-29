package com.ryan.tsa.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ryan.tsa.auth.domain.Role;
import com.ryan.tsa.auth.qo.RoleQo;
import com.ryan.tsa.auth.vo.RoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Repository
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 分页查询
     *
     * @param qo 查询条件
     * @return
     */
    List<RoleVo> queryList(RoleQo qo);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    void bacthDelete(@Param("ids") String ids);
}
