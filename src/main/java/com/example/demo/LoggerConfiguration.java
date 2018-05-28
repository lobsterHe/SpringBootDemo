package com.example.demo;

import com.example.demo.interceptor.LoggerInterceptor;
import com.example.demo.jpa.LoggerJpa;
import org.springframework.beans.factory.annotation.Autowired;
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

    //@Bean
    //public LoggerInterceptor loggerInterceptor(){
    //    System.out.println("嘻嘻嘻嘻")
    //    return new LoggerInterceptor(loggerDao);
    //}
    @Autowired
    private LoggerJpa loggerDao;
    /**
     * LoggerInterceptor,形成拦截链
     * @param registry 拦截器注册类
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //在放入拦截器之前调用loggerInterceptor(),触发LocalContainerEntityManagerFactoryBean使得拦截器的在注册之前所有的bean都持久化
        registry.addInterceptor(new LoggerInterceptor(loggerDao)).addPathPatterns("/**");
        System.out.println("呵呵呵呵");
    }
}
