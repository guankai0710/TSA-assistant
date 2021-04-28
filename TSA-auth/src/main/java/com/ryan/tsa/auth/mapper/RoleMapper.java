package com.ryan.tsa.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ryan.tsa.auth.domain.Role;
import com.ryan.tsa.auth.qo.RoleQo;
import com.ryan.tsa.auth.vo.RoleVo;
import org.apache.ibatis.annotations.Mapper;
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

    List<RoleVo> queryList(RoleQo qo);

}
