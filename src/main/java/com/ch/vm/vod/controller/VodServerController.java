package com.ch.vm.vod.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ch.vm.common.RespBean;
import com.ch.vm.vod.entity.VodServer;
import com.ch.vm.vod.service.VodServerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 点播地址维护 前端控制器
 * </p>
 *
 * @author 朱清
 * @since 2020-04-08
 */
@RestController
@RequestMapping("/vod/vod-server")
@Api(tags = "点播地址")
public class VodServerController {
    @Autowired
    VodServerService vodServerService;

    @GetMapping(value = "selectServer")
    @ApiOperation(value = "查询点播地址")
    public RespBean selectServer(){
        VodServer vodServer = vodServerService.getById(1);
        return RespBean.ok("ok",vodServer);
    }

    @PutMapping(value = "updateServer")
    @ApiOperation(value = "修改点播地址")
    @ApiImplicitParam(name = "vodServer",value = "点播地址实体",dataType = "VodServer")
    public RespBean updateServer(@RequestBody VodServer vodServer){
        int id = 1;
        UpdateWrapper<VodServer> bannerWrapper = new UpdateWrapper<>();
        bannerWrapper.eq("Id",id);
        vodServerService.update(vodServer,bannerWrapper);
        return RespBean.ok("ok","修改栏目成功");
    }
}
