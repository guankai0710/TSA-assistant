package com.ryan.tsa.auth.service;

import com.ryan.tsa.common.response.Result;

/**
 * <p>
 * 登录、注册、退出 接口
 * </p>
 *
 * @author Ryan
 * @since 2021-08-14
 */
public interface ILoginService {

    /**
     * 登录
     *
     * @param account 账号
     * @param password 密码
     * @return
     */
    Result login(String account, String password);

    /**
     * 注册
     *
     * @param account 账号
     * @param password 密码
     * @return
     */
    Result logon(String account, String password);


    /**
     * 退出
     *
     * @param token
     * @param personId 用户id
     * @return
     */
    Result logout(String token, Integer personId);

}
