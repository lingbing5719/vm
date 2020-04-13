package com.ch.vm.user.service.impl;

import com.ch.vm.user.entity.UserRole;
import com.ch.vm.user.mapper.UserRoleMapper;
import com.ch.vm.user.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联 服务实现类
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-03
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
