package com.ch.vm.user.service.impl;

import com.ch.vm.user.entity.MenuRole;
import com.ch.vm.user.mapper.MenuRoleMapper;
import com.ch.vm.user.service.MenuRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单和角色关联 服务实现类
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-03
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements MenuRoleService {

}
