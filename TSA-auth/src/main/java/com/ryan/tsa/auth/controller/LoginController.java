package com.ryan.tsa.auth.controller;


import com.ryan.tsa.auth.service.LoginService;
import com.ryan.tsa.common.controller.BaseController;
import com.ryan.tsa.common.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 登录、注册、退出  前端控制器
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/tsa/auth")
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     *
     * @param account 账号
     * @param password 密码
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestParam("account") String account, @RequestParam("password") String password){
        return loginService.login(account, password);
    }

    /**
     * 注册
     *
     * @param account 账号
     * @param password 密码
     * @return
     */
    @PostMapping("/logon")
    public Result logon(@RequestParam("account") String account, @RequestParam("password") String password){
        return loginService.logon(account, password);
    }


    /**
     * 退出
     *
     * @param personId 用户id
     * @return
     */
    @PostMapping("/logon")
    public Result logon(HttpServletRequest request, @RequestParam("personId") Integer personId){
        return loginService.logon(getToken(request), personId);
    }

}

