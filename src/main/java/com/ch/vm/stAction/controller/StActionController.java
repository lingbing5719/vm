package com.ch.vm.stAction.controller;


import com.ch.vm.common.RespBean;
import com.ch.vm.stAction.entity.StAction;
import com.ch.vm.stAction.service.StActionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 教师学生行为表 前端控制器
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-08
 */
@RestController
@RequestMapping("/stAction/st-action")
@Api(tags = "ST行为分析")
public class StActionController {
    @Autowired
    StActionService stActionService;

    @ApiOperation(value = "ST行为分析添加")
    @PostMapping(value = "addAction")
    public RespBean addAction(@RequestBody StAction stAction){
        stActionService.save(stAction);
        return RespBean.ok("ok","添加成功");
    }
}
