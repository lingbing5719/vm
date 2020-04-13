package com.ch.vm.vod.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ch.vm.common.RespBean;
import com.ch.vm.vod.entity.ResourceType;
import com.ch.vm.vod.mapper.ResourceTypeMapper;
import com.ch.vm.vod.service.ResourceTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 点播资源类型 前端控制器
 * </p>
 *
 * @author 朱清
 * @since 2020-04-08
 */
@RestController
@RequestMapping("/vod/resource-type")
@Api(tags = "点播资源类型")
public class ResourceTypeController {
    @Autowired
    ResourceTypeService resourceTypeService;
    @Autowired
    ResourceTypeMapper resourceTypeMapper;

    @GetMapping(value = "selectAllResourceType")
    @ApiOperation(value = "查找所有点播资源类型")
    public RespBean selectAllResourceType(){
        List<ResourceType> list =  resourceTypeService.list();
        return RespBean.ok("ok",list);
    }
    @ApiOperation(value = "点播资源类型分页查询")
    @GetMapping(value = "resourceTypeListPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageInfo", value = "分页信息", dataType = "Map<String,Integer>"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "int")
    })
    public RespBean resourceTypeListPage(@RequestBody Map<String,Integer> pageInfo){
        int pageNum = pageInfo.get("pageNum");
        int pageSize = pageInfo.get("pageSize");
        QueryWrapper<ResourceType> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("Id");
        Page<ResourceType> page = new Page<>(pageNum,pageSize);
        IPage<ResourceType> iPage = resourceTypeMapper.selectPage(page,queryWrapper);
        return RespBean.ok("获取成功",iPage);
    }

    @ApiOperation(value = "根据点播地址类型名称分页查询")
    @GetMapping(value = "resourceTypeListPageByName")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageInfo",value = "分页信息", dataType = "Map<String,Integer>"),
            @ApiImplicitParam(name = "pageNum",value = "第几页", dataType = "int"),
            @ApiImplicitParam(name = "pageSize",value = "每页条数", dataType = "int"),
            @ApiImplicitParam(name = "name",value = "点播资源类型名称",dataType = "String")
    })
    public RespBean resourceTypeListPageByName(@RequestBody Map<String,Object> map){
        int pageNum = (int)map.get("pageNum");
        int pageSize = (int)map.get("pageSize");
        String name = map.get("name").toString();
        QueryWrapper<ResourceType> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("name",name);
        Page<ResourceType> page = new Page<>(pageNum,pageSize);
        List<ResourceType> list = resourceTypeMapper.selectResourceTypePageByName(name,page);
        IPage<ResourceType> iPage = page.setRecords(list);
        return RespBean.ok("查询成功",iPage);
    }

    @PostMapping(value = "addResourceType")
    @ApiOperation(value = "添加点播资源类型")
    @ApiImplicitParam(name = "resourceType",value = "点播资源类型实体",dataType = "ResourceType")
    public RespBean addUrl(@RequestBody ResourceType resourceType){
        resourceTypeService.save(resourceType);
        return RespBean.ok("ok","点播资源类型添加成功");
    }

    @DeleteMapping(value = "deleteResourceType")
    @ApiOperation(value = "根据id删除点播资源类型")
    @ApiImplicitParam(name = "id",value = "点播资源类型id",dataType = "int")
    public RespBean deleteUrl(@RequestBody Map<String,Integer> map){
        int id = map.get("id");
        resourceTypeService.removeById(id);
        return RespBean.ok("ok","点播资源类型删除成功");
    }

    @PutMapping(value = "updateResourceType")
    @ApiOperation(value = "修改点播资源类型")
    @ApiImplicitParam(name = "resourceType",value = "点播资源类型实体",dataType = "ResourceType")
    public RespBean updateUrl(@RequestBody ResourceType resourceType){
        int id = resourceType.getId();
        UpdateWrapper<ResourceType> resourceTypeWrapper = new UpdateWrapper<>();
        resourceTypeWrapper.eq("Id",id);
        resourceTypeService.update(resourceType,resourceTypeWrapper);
        return RespBean.ok("ok","修改点播资源类型成功");
    }

    @GetMapping(value = "selectVO")
    @ApiOperation(value = "通过资源类型id查询资源类别")
    public RespBean selectVO(@RequestBody Map<String,Integer> map){
        int id = map.get("id");
        List<ResourceType> list = resourceTypeMapper.selectPageVO(id);
        return RespBean.ok("ok",list);
    }
}
