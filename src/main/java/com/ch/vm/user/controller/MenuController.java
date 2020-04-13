package com.ch.vm.user.controller;


import com.ch.vm.user.entity.Menu;
import com.ch.vm.user.entity.User;
import com.ch.vm.user.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单信息 前端控制器
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/user/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    /**
     *
     * @Author 朱清
     * @Date 2020/4/2 14:51
     * @Description: 用户列表分页
     */
    @GetMapping(value = "/test2",produces ="application/json;charset=UTF-8")
    public PageInfo userList(@RequestBody Map<String, Integer> page){
        int pageNum = page.get("pageNum");
        int pageSize = page.get("pageSize");
        PageHelper.startPage(pageNum,pageSize);
        List<Menu> users = menuService.getAllMenu();
        System.out.println(users);
        PageInfo<Menu> pageInfo = new PageInfo<Menu>(users);
        System.out.println(pageInfo);
        return pageInfo;
    }

}
