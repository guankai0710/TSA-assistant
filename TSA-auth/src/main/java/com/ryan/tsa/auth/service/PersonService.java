package com.ryan.tsa.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ryan.tsa.auth.domain.Person;
import com.ryan.tsa.auth.qo.PersonQo;
import com.ryan.tsa.auth.vo.PersonVo;
import com.ryan.tsa.common.response.PageResponse;

/**
 * <p>
 * 用户  服务类
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
public interface PersonService extends IService<Person> {

    /**
     * 分页查询
     *
     * @param qo 查询条件
     * @author ryan
     * @date 2021/4/30
     * @return
     **/
    PageResponse<PersonVo> pageList(PersonQo qo);

    /**
     * 根据用户id获取用户信息
     *
     * @param personId 用户id
     * @author ryan
     * @date 2021/4/29
     * @return
     **/
    PersonVo getById(Integer personId);

    /**
     * 根据账号获取用户信息
     *
     * @param account 账号
     * @author ryan
     * @date 2021/4/29
     * @return
     **/
    Person getByAccount(String account);

    /**
     * 新增
     *
     * @param json 用户信息
     * @author ryan
     * @date 2021/4/30
     * @return
     **/
    Boolean save(String json);

    /**
     * 修改在线状态
     *
     * @param personId 用户id
     * @param onlined 是否在线
     * @author ryan
     * @date 2021/4/29
     * @return
     **/
    Boolean updateOnlined(Integer personId, Integer onlined);

    /**
     * 修改密码
     *
     * @param personId 用户id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @author ryan
     * @date 2021/4/29
     * @return
     **/
    Boolean updatePwd(Integer personId, String oldPassword, String newPassword);

    /**
     * 重置密码
     *
     * @param personId 用户id
     * @author ryan
     * @date 2021/4/30
     * @return
     **/
    Boolean resetPwd(Integer personId);

    /**
     * 批量删除
     *
     * @param ids
     * @author ryan
     * @date 2021/4/30
     * @return
     */
    Boolean delete(String ids);

}
