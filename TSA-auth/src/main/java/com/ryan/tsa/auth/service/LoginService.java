package com.ryan.tsa.auth.service;

import com.ryan.tsa.common.response.Result;

/**
 * 类描述：登录、注册、退出
 *
 * @author guankai
 * @date 2021/4/29
 **/
public interface LoginService {

    Result login(String account, String password);

}
