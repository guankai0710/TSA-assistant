package com.ryan.tsa.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ryan.tsa.auth.domain.Role;
import com.ryan.tsa.auth.qo.RoleQo;
import com.ryan.tsa.auth.vo.RoleVo;
import com.ryan.tsa.common.response.PageResponse;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
public interface RoleService extends IService<Role> {

    PageResponse<RoleVo> pageList(RoleQo qo);

}
