package com.ch.vm.websiteInformation.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ch.vm.common.RespBean;
import com.ch.vm.websiteInformation.entity.Site;
import com.ch.vm.websiteInformation.service.SiteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 站点信息 前端控制器
 * </p>
 *
 * @author 朱清
 * @since 2020-04-07
 */
@RestController
@RequestMapping("/websiteInformation/site")
@Api(tags = "网站基础信息")
public class SiteController {

    @Autowired
    SiteService siteService;

    @ApiOperation(value = "网站基本设置修改")
    @ApiImplicitParam(name = "site",value = "网站信息实体",dataType = "Site")
    @PutMapping(value = "updateSite")
    public RespBean updateSite(@RequestBody Site site){
        UpdateWrapper<Site> siteUpdateWrapper = new UpdateWrapper<>();
        siteUpdateWrapper.eq("id",1);
        siteService.update(site,siteUpdateWrapper);
        return RespBean.ok("ok","修改成功");
    }

    @ApiOperation(value = "网站信息查询")
    @GetMapping(value = "selectSite")
    public RespBean selectSite(){
        Site site = siteService.getById(1);
        return  RespBean.ok("查询成功",site);
    }

}
