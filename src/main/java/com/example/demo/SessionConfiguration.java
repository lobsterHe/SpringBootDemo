package com.example.demo;

import com.example.demo.interceptor.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 将SessionInterceptor配置进springboot中
 * ========================
 *
 * @author 小龙虾
 * Created with IntelliJ IDEA.
 * Date：2018/1/11
 * Time：12:24
 * ========================
 */
@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter{
    /**
     * 将SessionInterceptor注册进去,形成拦截链
     * @param registry 拦截器注册类
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
    }
}
