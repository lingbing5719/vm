package com.ch.vm.demo.scheduled;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *  @author: 林乐福
 *  @Date: 2020/3/17 14:29
 *  @Description: 启动后执行某操作
 */
@Component
public class StartPingService implements CommandLineRunner {



    @Override
    public void run(String... args) throws Exception {
        System.out.printf("start : "+new Date());
    }

}