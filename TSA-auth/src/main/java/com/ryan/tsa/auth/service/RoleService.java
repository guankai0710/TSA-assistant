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
     * @author ryan
     * @date 2021/4/29
     */
    PageResponse<RoleVo> pageList(RoleQo qo);
    /**
     * 新增
     *
     * @param json 角色信息json字符串
     * @author ryan
     * @date 2021/4/29
     * @return
     **/
    Boolean save(String json);

    /**
     * 修改
     *
     * @param json 角色信息json字符串
     * @author ryan
     * @date 2021/4/29
     * @return
     **/
    Boolean update(String json);

    /**
     * 批量删除
     *
     * @param ids
     * @author ryan
     * @date 2021/4/29
     * @return
     */
    Boolean delete(String ids);

}
