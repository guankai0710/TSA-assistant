package com.ryan.tsa.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ryan.tsa.auth.domain.Role;
import com.ryan.tsa.common.vo.PageVo;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author ryan
 * @since 2021-04-23
 */
public interface RoleService extends IService<Role> {

    PageVo<Role> page(int pageNum, int pageSize);

}
