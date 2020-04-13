package com.ch.vm.user.service.impl;

import com.ch.vm.user.entity.Role;
import com.ch.vm.user.mapper.RoleMapper;
import com.ch.vm.user.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-03
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
