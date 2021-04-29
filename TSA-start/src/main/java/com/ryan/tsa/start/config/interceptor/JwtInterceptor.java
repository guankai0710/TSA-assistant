package com.ryan.tsa.start.config.interceptor;

import com.alibaba.fastjson.JSON;
import com.ryan.tsa.common.response.ResultCode;
import com.ryan.tsa.common.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guan.kai
 * @date 2020/8/6
 */

@Slf4j
@Component
public class JwtInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("data", "");
        response.setContentType("application/json; charset=utf-8");

        final String authHeader = request.getHeader(JwtUtil.AUTH_HEADER_KEY);

        //token是否存在
        if (StringUtils.isBlank(authHeader) || !authHeader.startsWith(JwtUtil.TOKEN_PREFIX)) {
            resultMap.put("code", ResultCode.TOKEN_NOT_EXIST.getCode());
            resultMap.put("msg", ResultCode.TOKEN_NOT_EXIST.getMsg());
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(JSON.toJSONString(resultMap).getBytes());
            outputStream.flush();
            return false;
        }

        final String token = authHeader.substring(JwtUtil.TOKEN_PREFIX.length());
        // 验证token是否过期
        if(!JwtUtil.checkToken(token) && JwtUtil.isExpiration(token)){
            resultMap.put("code", ResultCode.TOKEN_ERROR.getCode());
            resultMap.put("msg", ResultCode.TOKEN_ERROR.getMsg());
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(JSON.toJSONString(resultMap).getBytes());
            outputStream.flush();
            return false;
        }
        return true;
    }

}
