package com.ryan.tsa.auth.service;

import com.ryan.tsa.auth.domain.Person;
import com.baomidou.mybatisplus.extension.service.IService;

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
     * 根据账号获取用户信息
     *
     * @param account 账号
     * @author ryan
     * @date 2021/4/29
     * @return
     **/
    Person getByAccount(String account);

    /**
     * 修改在线状态
     *
     * @param personId 用户id
     * @param onlined 是否在线
     * @author guankai
     * @date 2021/4/29
     * @return
     **/
    boolean updateOnlined(Integer personId, Integer onlined);

}
