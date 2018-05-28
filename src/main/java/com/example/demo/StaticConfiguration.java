package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ========================
 *
 * @author 小龙虾
 * Created with IntelliJ IDEA.
 * Date：2018/2/12
 * Time：14:59
 * ========================
 */
@Configuration
public class StaticConfiguration extends WebMvcConfigurerAdapter {

    //自定义静态资源文件路径
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("hehe/static/resources/**").addResourceLocations("classpath:/static/images");
    }
}
