package com.ryan.tsa.auth.service;

import com.ryan.tsa.auth.domain.Person;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ryan.tsa.auth.qo.PersonQo;
import com.ryan.tsa.common.response.PageResponse;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author Ryan
 * @since 2021-08-13
 */
public interface IPersonService extends IService<Person> {

    /**
     * 分页查询
     *
     * @param qo 查询条件
     * @author Ryan
     * @date 2021/8/13
     * @return
     **/
    PageResponse<Person> pageList(PersonQo qo);

    /**
     * 根据账号查询用户信息
     *
     * @param account 账号
     * @author Ryan
     * @date 2021/8/13
     * @return
     **/
    Person getByAccount(String account);

    /**
     * 修改用户密码
     *
     * @param personId 用户id
     * @param oldPassword 老密码
     * @param newPassword 新密码
     * @author Ryan
     * @date 2021/8/13
     * @return
     **/
    Boolean updatePasswordById(Integer personId, String oldPassword, String newPassword);

    /**
     * 修改用户在线状态
     *
     * @param personId 用户id
     * @param onlined 在线状态
     * @author Ryan
     * @date 2021/8/13
     * @return
     **/
    Boolean updateOnlined(Integer personId, Integer onlined);

    /**
     * 修改用户启用状态
     *
     * @param personId 用户id
     * @param enabled 启用状态
     * @author Ryan
     * @date 2021/8/13
     * @return
     **/
    Boolean updateEnabled(Integer personId, Integer enabled);

}
