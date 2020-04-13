package com.ch.vm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.ch.vm.*.mapper")
//@EnableCaching
@EnableScheduling
public class VmApplication {

    public static void main(String[] args) {
        SpringApplication.run(VmApplication.class, args);
    }

}
