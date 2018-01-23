package com.example.demo;

import com.example.demo.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ========================
 *
 * @author 小龙虾
 * Created with IntelliJ IDEA.
 * Date：2018/1/23
 * Time：11:51
 * ========================
 */
@Configuration
public class LoggerConfiguration extends WebMvcConfigurerAdapter {
    /**
     * LoggerInterceptor,形成拦截链
     * @param registry 拦截器注册类
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
    }
}
