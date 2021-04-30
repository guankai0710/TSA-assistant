package com.ryan.tsa.common.controller;

import com.ryan.tsa.common.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 类描述：前端控制器基础类
 *
 * @author ryan
 * @date 2021/4/29
 **/
public class BaseController {

    /**
     * 获取token
     *
     * @param request
     * @author guankai
     * @date 2021/4/29
     * @return
     **/
    protected String getToken(HttpServletRequest request){
        return request.getHeader(JwtUtil.AUTH_HEADER_KEY).substring(JwtUtil.TOKEN_PREFIX.length());
    }

    /**
     * 解析token获取用户id
     *
     * @param request
     * @author guankai
     * @date 2021/4/29
     * @return
     **/
    protected Integer getPersonId(HttpServletRequest request){
        Jws<Claims> claimsJws = JwtUtil.parseToken(getToken(request));
        return Integer.valueOf(claimsJws.getBody().get("personId").toString());
    }

    /**
     * 解析token获取用户账号
     *
     * @param request
     * @author guankai
     * @date 2021/4/29
     * @return
     **/
    protected Integer getAccount(HttpServletRequest request){
        Jws<Claims> claimsJws = JwtUtil.parseToken(getToken(request));
        return Integer.valueOf(claimsJws.getBody().get("account").toString());
    }

    /**
     * 解析token获取角色id
     *
     * @param request
     * @author guankai
     * @date 2021/4/29
     * @return
     **/
    protected Integer getRoleId(HttpServletRequest request){
        Jws<Claims> claimsJws = JwtUtil.parseToken(getToken(request));
        return Integer.valueOf(claimsJws.getBody().get("roleId").toString());
    }

    /**
     * 封装Boolean类型的操作结果
     *
     * @param result
     * @author guankai
     * @date 2021/4/29
     * @return
     **/
    protected Map<String, Boolean> restResult(boolean result) {
        Map<String, Boolean> resultMap = new HashMap<>(2);
        resultMap.put("result", result);
        return resultMap;
    }
}
