package com.ch.vm.websiteInformation.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ch.vm.common.RespBean;
import com.ch.vm.websiteInformation.entity.Banner;
import com.ch.vm.websiteInformation.entity.UploadFileUrl;
import com.ch.vm.websiteInformation.mapper.BannerMapper;
import com.ch.vm.websiteInformation.service.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 各栏目banner 前端控制器
 * </p>
 *
 * @author 朱清
 * @since 2020-04-08
 */
@RestController
@RequestMapping("/websiteInformation/banner")
@Api(tags = "栏目图展")
public class BannerController {
    @Autowired
    BannerService bannerService;

    @Autowired
    BannerMapper bannerMapper;

    @ApiOperation(value = "查找所有栏目图展")
    @GetMapping(value = "bannerList")
    public RespBean bannerList(){
        List<Banner> list = new ArrayList<>();
        list = bannerService.list();
        return RespBean.ok("查询成功",list);
    }

    @ApiOperation(value = "分页查询")
    @GetMapping(value = "bannerListPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageInfo", value = "分页信息", dataType = "Map<String,Integer>"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "int")
    })
    public RespBean bannerListPage(@RequestBody Map<String,Integer> pageInfo){
        int pageNum = pageInfo.get("pageNum");
        int pageSize = pageInfo.get("pageSize");
        QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("Id");
        Page<Banner> page = new Page<>(pageNum,pageSize);
        IPage<Banner> iPage = bannerMapper.selectPage(page,queryWrapper);
        return RespBean.ok("获取成功",iPage);
    }

    @ApiOperation(value = "根据栏目名称分页查询")
    @GetMapping(value = "bannerListPageByName")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageInfo",value = "分页信息", dataType = "Map<String,Integer>"),
            @ApiImplicitParam(name = "pageNum",value = "第几页", dataType = "int"),
            @ApiImplicitParam(name = "pageSize",value = "每页条数", dataType = "int"),
            @ApiImplicitParam(name = "name",value = "栏目名称",dataType = "String")
    })
    public RespBean bannerListPageByName(@RequestBody Map<String,Object> map){
        int pageNum = (int)map.get("pageNum");
        int pageSize = (int)map.get("pageSize");
        String name = map.get("name").toString();
        QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("name",name);
        Page<Banner> page = new Page<>(pageNum,pageSize);
        List<Banner> list = bannerMapper.selectBannerPageByName(name,page);
        IPage<Banner> iPage = page.setRecords(list);
        return RespBean.ok("查询成功",iPage);
    }

    @PostMapping(value = "addBanner")
    @ApiOperation(value = "添加栏目")
    @ApiImplicitParam(name = "banner",value = "栏目实体",dataType = "Banner")
    public RespBean addUrl(@RequestBody Banner banner){
        bannerService.save(banner);
        return RespBean.ok("ok","栏目添加成功");
    }

    @DeleteMapping(value = "deleteBanner")
    @ApiOperation(value = "根据id删除栏目")
    @ApiImplicitParam(name = "id",value = "栏目id",dataType = "int")
    public RespBean deleteUrl(@RequestBody Map<String,Integer> map){
        int id = map.get("id");
        bannerService.removeById(id);
        return RespBean.ok("ok","栏目删除成功");
    }

    @PutMapping(value = "updateBanner")
    @ApiOperation(value = "修改栏目")
    @ApiImplicitParam(name = "banner",value = "栏目实体",dataType = "Banner")
    public RespBean updateUrl(@RequestBody Banner banner){
        int id = banner.getId();
        UpdateWrapper<Banner> bannerWrapper = new UpdateWrapper<>();
        bannerWrapper.eq("Id",id);
        bannerService.update(banner,bannerWrapper);
        return RespBean.ok("ok","修改栏目成功");
    }
}
