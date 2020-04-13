package com.ch.vm.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ch.vm.common.RespBean;
import com.ch.vm.log.entity.Oplog;
import com.ch.vm.log.service.OplogService;
import com.ch.vm.user.entity.Role;
import com.ch.vm.user.entity.User;
import com.ch.vm.user.service.RoleService;
import com.ch.vm.user.service.UserService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-03
 */
@Api("log")
@RestController
@RequestMapping("/user/user")
public class UserController {
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;
    @Autowired
    OplogService oplogService;

    @ApiOperation("用户信息")
    @GetMapping("list")
    public RespBean list() {
        List<Role> roles = roleService.list();
        UserDetails userDetails = userService.loadUserByUsername("admin");
        Oplog oplog=new Oplog();
        oplog.setOperate("查询用户");
        oplogService.save(oplog);


//        QueryWrapper<Role> wrapper = new QueryWrapper<>();
//        wrapper.ge("id",1);
//        Page<Role> page = new Page<>(1, 2);
//        IPage<Role> roleIPage = roleService.page(page, wrapper);
//        System.out.println("总条数"+roleIPage.getTotal());
//        System.out.println("总页数"+roleIPage.getPages());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.ge("id",1);
        Page<User> page = new Page<>(1, 2);
        IPage<User> userIPage = userService.page(page, wrapper);
        System.out.println("总条数"+userIPage.getTotal());
        System.out.println("总页数"+userIPage.getPages());

        return RespBean.ok("获取成功", userIPage);
    }


}
