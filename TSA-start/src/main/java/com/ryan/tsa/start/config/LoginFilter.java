package com.ryan.tsa.start.config;

import com.alibaba.fastjson.JSON;
import com.ryan.tsa.common.response.ResultCode;
import com.ryan.tsa.common.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * 类描述: 登陆拦截器
 *
 * @author ryan
 * @date 2020/8/6
 */
@Component
@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
@Slf4j
public class LoginFilter implements Filter, Ordered {


    private static final List<String> EXCLUDED_PATHS = new ArrayList<>(10);

    static {
        //接口白名单
        EXCLUDED_PATHS.add("/tsa/auth/login");

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //放行白名单路径
        if (EXCLUDED_PATHS.stream().anyMatch(request.getRequestURI()::endsWith)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return ;
        }

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
        }

        final String token = authHeader.substring(JwtUtil.TOKEN_PREFIX.length());
        // 验证token是否过期
        if(!JwtUtil.checkToken(token)){
            resultMap.put("code", ResultCode.TOKEN_ERROR.getCode());
            resultMap.put("msg", ResultCode.TOKEN_ERROR.getMsg());
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(JSON.toJSONString(resultMap).getBytes());
            outputStream.flush();
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public int getOrder() {
        // filter加载顺序是从小到大，平常建议设置一个较大值，防止影响系统自带filter
        return Integer.MAX_VALUE;
    }
}
