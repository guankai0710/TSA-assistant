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

    /**
     * 分页查询
     *
     * @param qo 查询条件
     * @return
     */
    PageResponse<RoleVo> pageList(RoleQo qo);
    /**
     * 新增
     *
     * @param roleName 角色名称
     * @param memo 备注
     * @author guankai
     * @date 2021/4/29
     * @return
     **/
    boolean save(String roleName, String memo);

    /**
     * 修改
     *
     * @param roleId 角色id
     * @param roleName 角色名称
     * @param memo 备注
     * @author guankai
     * @date 2021/4/29
     * @return
     **/
    boolean update(Integer roleId, String roleName, String memo);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    boolean bacthDelete(String ids);

}
