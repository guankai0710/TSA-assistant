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
     * 解析token获取用户id
     *
     * @param request
     * @author guankai
     * @date 2021/4/29
     * @return
     **/
    protected Integer getPersonId(HttpServletRequest request){
        String token = request.getHeader(JwtUtil.AUTH_HEADER_KEY).substring(JwtUtil.TOKEN_PREFIX.length());
        Jws<Claims> claimsJws = JwtUtil.parseToken(token);
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
        String token = request.getHeader(JwtUtil.AUTH_HEADER_KEY).substring(JwtUtil.TOKEN_PREFIX.length());
        Jws<Claims> claimsJws = JwtUtil.parseToken(token);
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
        String token = request.getHeader(JwtUtil.AUTH_HEADER_KEY).substring(JwtUtil.TOKEN_PREFIX.length());
        Jws<Claims> claimsJws = JwtUtil.parseToken(token);
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
