package com.ch.vm.vod.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 点播资源附件表
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-08
 */
@TableName("vm_resource_resource")
@ApiModel(value="ResourceResource对象", description="点播资源附件表")
public class ResourceResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    @ApiModelProperty(value = "资源所属类型 优质课/网络教研")
    private String classify;

    @ApiModelProperty(value = "所属点播资源目录id")
    @TableField("classifyId")
    private Integer classifyId;

    @ApiModelProperty(value = "附件类型")
    private String type;

    @ApiModelProperty(value = "附件大小")
    private String size;

    @ApiModelProperty(value = "相对存储位置")
    @TableField("saveUrl")
    private String saveUrl;

    @ApiModelProperty(value = "上传人id")
    @TableField("createUserId")
    private String createUserId;

    @ApiModelProperty(value = "上传时间")
    @TableField("createTime")
    private String createTime;

    @ApiModelProperty(value = "审核状态（0未审核）（1审核通过）（2审核未通过）（3禁用）")
    private String status;

    @ApiModelProperty(value = "后缀名")
    private String suffix;

    @ApiModelProperty(value = "附件名称")
    private String name;

    @ApiModelProperty(value = "本地硬盘保存名字")
    @TableField("saveName")
    private String saveName;

    @TableField("contentsName")
    private String contentsName;

    private String stime;

    private String etime;

    @ApiModelProperty(value = "md5码")
    @TableField("dis_resourceMd5")
    private String disResourcemd5;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }
    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }
    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    public String getSaveUrl() {
        return saveUrl;
    }

    public void setSaveUrl(String saveUrl) {
        this.saveUrl = saveUrl;
    }
    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }
    public String getContentsName() {
        return contentsName;
    }

    public void setContentsName(String contentsName) {
        this.contentsName = contentsName;
    }
    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }
    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }
    public String getDisResourcemd5() {
        return disResourcemd5;
    }

    public void setDisResourcemd5(String disResourcemd5) {
        this.disResourcemd5 = disResourcemd5;
    }

    @Override
    public String toString() {
        return "ResourceResource{" +
            "Id=" + Id +
            ", classify=" + classify +
            ", classifyId=" + classifyId +
            ", type=" + type +
            ", size=" + size +
            ", saveUrl=" + saveUrl +
            ", createUserId=" + createUserId +
            ", createTime=" + createTime +
            ", status=" + status +
            ", suffix=" + suffix +
            ", name=" + name +
            ", saveName=" + saveName +
            ", contentsName=" + contentsName +
            ", stime=" + stime +
            ", etime=" + etime +
            ", disResourcemd5=" + disResourcemd5 +
        "}";
    }
}
