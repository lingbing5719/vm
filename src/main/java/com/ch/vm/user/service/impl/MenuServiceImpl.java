package com.ch.vm.user.service.impl;

import com.ch.vm.user.entity.Menu;
import com.ch.vm.user.mapper.MenuMapper;
import com.ch.vm.user.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单信息 服务实现类
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-03
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    MenuMapper menuMapper;


    @Override
    public List<Menu> getAllMenu() {
        return menuMapper.getAllMenu();
    }
}
