package com.ch.vm.user.service.impl;

import com.ch.vm.user.entity.UserType;
import com.ch.vm.user.mapper.UserTypeMapper;
import com.ch.vm.user.service.UserTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户身份列表 服务实现类
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-03
 */
@Service
public class UserTypeServiceImpl extends ServiceImpl<UserTypeMapper, UserType> implements UserTypeService {

}
