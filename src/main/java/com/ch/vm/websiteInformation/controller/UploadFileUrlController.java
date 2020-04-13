package com.ch.vm.websiteInformation.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ch.vm.common.RespBean;
import com.ch.vm.websiteInformation.entity.UploadFileUrl;
import com.ch.vm.websiteInformation.mapper.UploadFileUrlMapper;
import com.ch.vm.websiteInformation.service.UploadFileUrlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 上传目录设置 前端控制器
 * </p>
 *
 * @author 朱清
 * @since 2020-04-07
 */
@RestController
@RequestMapping("/websiteInformation/upload-file-url")
@Api(tags = "上传目录")
public class UploadFileUrlController {
    @Autowired
    UploadFileUrlService uploadFileUrlService;
    @Autowired
    UploadFileUrlMapper uploadFileUrlMapper;

    @PutMapping(value = "disableFileUrl")
    @ApiOperation(value = "根据id禁用上传文件目录")
    @ApiImplicitParam(name = "id",value = "上传文件目录id")
    public RespBean disable(@RequestBody Map<String, Integer> map){
        int id = map.get("id");
        UploadFileUrl uploadFileUrl = uploadFileUrlService.getById(id);
        uploadFileUrl.setIsValid("禁用");
        UpdateWrapper<UploadFileUrl> uploadFileUrlUpdateWrapper = new UpdateWrapper<>();
        uploadFileUrlUpdateWrapper.eq("id",id);
        uploadFileUrlService.update(uploadFileUrl,uploadFileUrlUpdateWrapper);
        return RespBean.ok("ok","上传目录已禁用");
    }

    @PutMapping(value = "ableFileUrl")
    @ApiOperation(value = "根据id启用上传文件目录")
    @ApiImplicitParam(name = "id",value = "上传文件目录id")
    public RespBean able(@RequestBody Map<String,Integer> map){
        int id = map.get("id");
        UploadFileUrl uploadFileUrl = uploadFileUrlService.getById(id);
        uploadFileUrl.setIsValid("启用");
        UpdateWrapper<UploadFileUrl> uploadFileUrlUpdateWrapper = new UpdateWrapper<>();
        uploadFileUrlUpdateWrapper.eq("id",id);
        uploadFileUrlService.update(uploadFileUrl,uploadFileUrlUpdateWrapper);
        return RespBean.ok("ok","上传目录已开启");
    }

    @PostMapping(value = "addFileUrl")
    @ApiOperation(value = "添加上传目录")
    @ApiImplicitParam(name = "uploadFileUrl",value = "上传目录实体")
    public RespBean addUrl(@RequestBody UploadFileUrl uploadFileUrl){
        uploadFileUrlService.save(uploadFileUrl);
        return RespBean.ok("ok","上传目录添加成功");
    }

    @DeleteMapping(value = "deleteFileUrl")
    @ApiOperation(value = "根据id删除上传目录")
    @ApiImplicitParam(name = "id",value = "上传文件目录id",dataType = "int")
    public RespBean deleteUrl(@RequestBody Map<String,Integer> map){
        int id = map.get("id");
        uploadFileUrlService.removeById(id);
        return RespBean.ok("ok","上传目录删除成功");
    }

    @PutMapping(value = "updateFileUrl")
    @ApiOperation(value = "修改上传目录")
    @ApiImplicitParam(name = "uploadFileUrl",value = "上传目录实体",dataType = "UploadFileUrl")
    public RespBean updateUrl(@RequestBody UploadFileUrl uploadFileUrl){
        int id = uploadFileUrl.getId();
        UpdateWrapper<UploadFileUrl> fileUrlUpdateWrapper = new UpdateWrapper<>();
        fileUrlUpdateWrapper.eq("id",id);
        uploadFileUrlService.update(uploadFileUrl,fileUrlUpdateWrapper);
        return RespBean.ok("ok","修改上传目录成功");
    }

    @GetMapping(value = "fileUrlPage")
    @ApiOperation(value = "上传目录分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageInfo", value = "分页信息", dataType = "Map<String,Integer>"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "int")
    })
    public RespBean fileUrlPage(@RequestBody Map<String,Integer> pageInfo){
        int pageNum = pageInfo.get("pageNum");
        int pageSize = pageInfo.get("pageSize");
        QueryWrapper<UploadFileUrl> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");
        Page<UploadFileUrl> page = new Page<>(pageNum,pageSize);
        IPage<UploadFileUrl> iPage = uploadFileUrlMapper.selectPage(page,queryWrapper);
        return RespBean.ok("获取成功",iPage);
    }


}
