package com.ryan.tsa.common.controller;

import com.ryan.tsa.common.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import javax.servlet.http.HttpServletRequest;

/**
 * 类描述：前端控制器基础类
 *
 * @author ryan
 * @date 2021/4/29
 **/
public class BaseController {

    public Integer getPersonId(HttpServletRequest request){
        String token = request.getHeader(JwtUtil.AUTH_HEADER_KEY).substring(JwtUtil.TOKEN_PREFIX.length());
        Jws<Claims> claimsJws = JwtUtil.parseToken(token);
        return Integer.valueOf(claimsJws.getBody().get("personId").toString());
    }

    public Integer getRoleId(HttpServletRequest request){
        String token = request.getHeader(JwtUtil.AUTH_HEADER_KEY).substring(JwtUtil.TOKEN_PREFIX.length());
        Jws<Claims> claimsJws = JwtUtil.parseToken(token);
        return Integer.valueOf(claimsJws.getBody().get("roleId").toString());
    }
}
