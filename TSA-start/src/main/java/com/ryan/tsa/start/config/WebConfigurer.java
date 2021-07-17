//package com.ryan.tsa.start.config;
//
//import com.ryan.tsa.start.config.interceptor.JwtInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * web拦截器配置类
// *
// * @author ryan
// * @date 2020/8/6
// **/
//@Configuration
//public class WebConfigurer implements WebMvcConfigurer {
//
//    /** 接口白名单 */
//    private static final String[] EXCLUDE_PATHS = {
//            /******************* 权限部分 *****************/
//            "/tsa/auth/login",
//            "/tsa/auth/logon"
//    };
//
//
//    /** 登录拦截器 */
//    @Autowired
//    private JwtInterceptor jwtInterceptor;
//
//    /**
//     * 注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
//     *
//     * @param registry
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(jwtInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns(EXCLUDE_PATHS);
//    }
//
//
//}
