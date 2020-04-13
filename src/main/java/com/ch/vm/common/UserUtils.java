package com.ch.vm.common;

import com.ch.vm.user.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 *  @author: 林乐福
 *  @Date: 2020/2/26 13:17
 *  @Description: 获取当前用户信息
 */ 
public class UserUtils {
    public static User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
