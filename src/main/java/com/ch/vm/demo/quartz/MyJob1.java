package com.ch.vm.demo.quartz;

import org.springframework.stereotype.Component;

import java.util.Date;


/**
 *  @author: 林乐福
 *  @Date: 2020/3/17 14:33
 *  @Description:
 */ 
@Component
public class MyJob1 {
    public void hello() {
        System.out.println("MyJob1>>>"+new Date());
    }
}
