package com.ch.vm.demo.quartz;

import java.util.Date;


/**
 *  @author: 林乐福
 *  @Date: 2020/3/17 14:32
 *  @Description:
 */ 
public class HelloService {
    public String sayHello() {
        return "HelloService:" + new Date();
    }
}
