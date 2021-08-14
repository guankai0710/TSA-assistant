package com.ryan.tsa.auth.service;

import com.ryan.tsa.auth.domain.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ryan.tsa.auth.qo.RoleQo;
import com.ryan.tsa.common.response.PageResponse;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色信息 服务类
 * </p>
 *
 * @author Ryan
 * @since 2021-08-13
 */
public interface IRoleService extends IService<Role> {

    /**
     * 分页查询
     *
     * @param qo 查询条件
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    PageResponse<Role> pageList(RoleQo qo);


    /**
     * 角色下拉列表
     *
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    List<Map<String,Object>> dropDownList();


}
