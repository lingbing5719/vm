package com.ch.vm.websiteInformation.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 各栏目banner
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-08
 */
@TableName("vm_banner")
@ApiModel(value="Banner对象", description="各栏目banner")
public class Banner implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    @ApiModelProperty(value = "标题")
    private String name;

    @ApiModelProperty(value = "分类")
    private String classify;

    @ApiModelProperty(value = "图片存储位置")
    @TableField("picUrl")
    private String picUrl;

    @ApiModelProperty(value = "图片链接地址")
    private String url;

    @ApiModelProperty(value = "创建者ID")
    @TableField("creatorId")
    private String creatorId;

    @ApiModelProperty(value = "创建时间")
    @TableField("creatorTime")
    private String creatorTime;

    @ApiModelProperty(value = "介绍")
    private String introduction;

    @ApiModelProperty(value = "是否启用")
    @TableField("isValid")
    private String isValid;

    @ApiModelProperty(value = "banner位置")
    private String place;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }
    public String getCreatorTime() {
        return creatorTime;
    }

    public void setCreatorTime(String creatorTime) {
        this.creatorTime = creatorTime;
    }
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Banner{" +
            "Id=" + Id +
            ", name=" + name +
            ", classify=" + classify +
            ", picUrl=" + picUrl +
            ", url=" + url +
            ", creatorId=" + creatorId +
            ", creatorTime=" + creatorTime +
            ", introduction=" + introduction +
            ", isValid=" + isValid +
            ", place=" + place +
        "}";
    }
}
