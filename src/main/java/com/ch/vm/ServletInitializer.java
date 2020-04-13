package com.ch.vm;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 *  @author: 林乐福
 *  @Date: 2020/2/28 10:28
 *  @Description:
 */ 
public class ServletInitializer extends SpringBootServletInitializer {
    public ServletInitializer() {
        System.out.println("初始化ServletInitializer");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(VmApplication.class);//VmApplication是启动类名
    }
}