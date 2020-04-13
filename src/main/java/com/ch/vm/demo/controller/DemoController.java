package com.ch.vm.demo.controller;

import com.ch.vm.common.RespBean;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 林乐福
 * @Date: 2020/3/4 16:06
 * @Description: 样例代码
 */
@RestController
@Api(tags = "用户管理相关接口文档使用演示")
@RequestMapping("/demo/user")
public class DemoController {
    //日志
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
//
//    //操作写入数据库
//    @Autowired
//    OplogService oplogSer;
//    @Autowired
//    UserService userService;
//    @Autowired
//    RoleService roleService;
//
//    @ApiOperation("根据id查找用户的接口")
//    @ApiImplicitParam(name = "userId", value = "用户id")
//    @GetMapping("/id/{userId}")
//    public User getUserById(@PathVariable Long userId) {
//        return userService.getUserById(userId);
//    }
//
//
//    @ApiOperation("根据id删除用户的接口")
//    @ApiImplicitParam(name = "userId", value = "用户id")
//    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
//    public RespBean deleteUser(@PathVariable Long userId) {
//        //日志操作
//        logger.info("LOG : 删除用户");
//        //操作日志写入数据库
////        Oplog op = new Oplog("关键操作内容记录--删除用户", 3);
////        oplogSer.addOplog(op);
//        if (userService.deleteUser(userId) == 1) {
//            return RespBean.ok("删除成功!");
//        }
//        return RespBean.error("删除失败!");
//    }
//
//
//    @ApiOperation("更新用户的接口")
//    @ApiImplicitParam(name = "user", value = "用户实体")
//    @RequestMapping(value = "/", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
//    public RespBean updateUser(@RequestBody User user) {
//        if (userService.updateUser(user) == 1) {
//            return RespBean.ok("更新成功!");
//        }
//        return RespBean.error("更新失败!");
//    }
//
//    /**
//     * @Description
//     * @Author 林乐福
//     * @Date 2020/3/5 16:13
//     * @Param [user]
//     * @Return com.ch.vm.model.RespBean
//     * @Exception
//     * @demo {
//     * "id": "13",
//     * "roles": [{"id":"6"}, {"id":"13"}]
//     * }
//     */
//    @ApiOperation("根据用户id更新用户角色的接口")
//    @ApiImplicitParam(name = "user", value = "用户实体")
//    @RequestMapping(value = "/roles", method = RequestMethod.PUT)
//    public RespBean updateUserRoles(@RequestBody User user) {
//        if (userService.updateUserRoles(user.getId(), user.getRoles()) == user.getRoles().size()) {
//            return RespBean.ok("更新成功!");
//        }
//        return RespBean.error("更新失败!");
//    }
//
//    @ApiOperation("关键字(中文需要url编码转换)查询用户的接口")
//    @ApiImplicitParam(name = "keywords", value = "关键字", required = false)
//    @RequestMapping(value = "/{keywords}", method = RequestMethod.GET)
//    public List<User> getUsersByKeywords(@PathVariable(name = "keywords") String keywords) {
//        List<User> Users = userService.getUsersByKeywords(keywords);
//        return Users;
//    }
//
//    @ApiOperation("获取所有角色的接口")
//    @RequestMapping(value = "/roles", method = RequestMethod.GET)
//    public List<Role> allRoles() {
//        return roleService.roles();
//    }
//
//    @ApiOperation("注册用户")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "username", value = "用户名"),
//            @ApiImplicitParam(name = "password", value = "密码")
//    }
//    )
//    @RequestMapping(value = "/User/reg", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    public RespBean UserReg(@RequestBody Map<String, String> user) {
//        int i = userService.UserReg(user.get("username"), user.get("password"));
//        if (i == 1) {
//            return RespBean.ok("注册成功!");
//        } else if (i == -1) {
//            return RespBean.error("用户名重复，注册失败!");
//        }
//        return RespBean.error("注册失败!");
//    }

    @GetMapping(value = "/test1",produces ="application/json;charset=UTF-8")
    public RespBean test(@RequestParam String json){
        return RespBean.ok("测试成功!");
    }






}
