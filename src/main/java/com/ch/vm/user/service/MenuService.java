package com.ch.vm.user.service;

import com.ch.vm.user.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单信息 服务类
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-03
 */
public interface MenuService extends IService<Menu> {

    List<Menu> getAllMenu();
}
