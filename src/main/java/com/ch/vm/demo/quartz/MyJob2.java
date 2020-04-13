package com.ch.vm.demo.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


/**
 *  @author: 林乐福
 *  @Date: 2020/3/17 14:33
 *  @Description:
 */ 
public class MyJob2 extends QuartzJobBean {
    HelloService helloService;

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println(helloService.sayHello());
    }
}
