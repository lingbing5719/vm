package com.ch.vm.demo.scheduled;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 *  @author: 林乐福
 *  @Date: 2020/3/17 12:44
 *  @Description: springBoot 启动后执行某操作
 */

@Component
public class ApplicationStartQuartzJobListener implements ApplicationListener<ContextRefreshedEvent> {

//    @Autowired
//    private QuartzManager quartzManager;

    /**
     * 初始启动quartz
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
//            quartzManager.start();
            System.out.println("任务已经启动..."+new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}