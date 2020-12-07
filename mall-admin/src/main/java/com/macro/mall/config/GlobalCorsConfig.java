package com.macro.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 全局跨域配置
 * 注意：前端从网关进行调用时需要配置
 * Created by macro on 2019/7/27.
 */
@Configuration
public class GlobalCorsConfig {

    @Bean
    public Filter getCORSFilter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                response.setHeader("Access-Control-Allow-Origin", "*"); //允许哪些url可以跨域请求到本域
                response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS"); //允许的请求方法，一般是GET,POST,PUT,DELETE,OPTIONS
                response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type,sign,timestamp"); //允许哪些请求头可以跨域
                filterChain.doFilter(request, response);
            }
        };
    }


}
