package com.ryan.tsa.start.config;

import com.ryan.tsa.start.config.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web拦截器配置类
 *
 * @author: guan.kai
 * @date: 2019/8/29 17:31
 **/
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    /** 接口白名单 */
    private static final String[] EXCLUDE_PATHS = {
            /******************* 权限部分 *****************/
            "/auth/login",
            "/auth/logon",
            "/auth/logout"
    };


    /** 登录拦截器 */
    @Autowired
    private JwtInterceptor jwtInterceptor;

    /**
     * 注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(EXCLUDE_PATHS);
    }


}
