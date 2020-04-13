package com.ch.vm.user.service;

import com.ch.vm.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-03
 */
public interface UserService extends IService<User>, UserDetailsService {




}
