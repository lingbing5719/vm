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
 * 点播资源目录表
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-08
 */
@TableName("vm_resource_contents")
@ApiModel(value="ResourceContents对象", description="点播资源目录表")
public class ResourceContents implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    @ApiModelProperty(value = "资源名称")
    private String name;

    @ApiModelProperty(value = "讲授人姓名")
    @TableField("teacherName")
    private String teacherName;

    private String city;

    @ApiModelProperty(value = "讲授人所在学校类型名")
    @TableField("schoolType")
    private String schoolType;

    @ApiModelProperty(value = "讲授人所在学校名")
    private String school;

    @ApiModelProperty(value = "学段名")
    @TableField("studySection")
    private String studySection;

    @ApiModelProperty(value = "学科名")
    private String course;

    @ApiModelProperty(value = "版本名")
    private String press;

    @ApiModelProperty(value = "册别名")
    private String volume;

    @ApiModelProperty(value = "章节 教材表id")
    @TableField("contentsName")
    private String contentsName;

    @ApiModelProperty(value = "创建人id")
    @TableField("createUserId")
    private String createUserId;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private String createTime;

    @ApiModelProperty(value = "是否上传对应资源0未1上传")
    private String appendix;

    @ApiModelProperty(value = "是否上传对应资源播放文件0未1上传")
    private String resource;

    @ApiModelProperty(value = "资源介绍")
    private String introduction;

    @ApiModelProperty(value = "资源状态（0等待完善）（1等待审核）（2审核通过）（3审核未通过）（4禁用）")
    private String status;

    @ApiModelProperty(value = "资源类型名称")
    @TableField("resourceType")
    private Integer resourceType;

    @ApiModelProperty(value = "资源类别名称")
    @TableField("resourceClassify")
    private Integer resourceClassify;

    @ApiModelProperty(value = "全存为“教学视频”")
    private String type;

    @ApiModelProperty(value = "缩略图")
    @TableField("picUrl")
    private String picUrl;

    @ApiModelProperty(value = "这才是真正的章节")
    @TableField("contentsNameId")
    private String contentsNameId;

    @ApiModelProperty(value = "被点击次数")
    @TableField("hitCount")
    private Integer hitCount;

    @ApiModelProperty(value = "0未推荐1推荐")
    @TableField("isRecommend")
    private String isRecommend;

    @ApiModelProperty(value = "发布人所在城市")
    @TableField("createUserCity")
    private String createUserCity;

    @ApiModelProperty(value = "发布人所在单位")
    @TableField("createUserSchoolId")
    private String createUserSchoolId;

    @ApiModelProperty(value = "发布范围")
    @TableField("liveScope")
    private String liveScope;

    @ApiModelProperty(value = "点播资源md5")
    @TableField("dis_contentMd5")
    private String disContentmd5;

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
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
    public String getStudySection() {
        return studySection;
    }

    public void setStudySection(String studySection) {
        this.studySection = studySection;
    }
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }
    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
    public String getContentsName() {
        return contentsName;
    }

    public void setContentsName(String contentsName) {
        this.contentsName = contentsName;
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
    public String getAppendix() {
        return appendix;
    }

    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }
    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }
    public Integer getResourceClassify() {
        return resourceClassify;
    }

    public void setResourceClassify(Integer resourceClassify) {
        this.resourceClassify = resourceClassify;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    public String getContentsNameId() {
        return contentsNameId;
    }

    public void setContentsNameId(String contentsNameId) {
        this.contentsNameId = contentsNameId;
    }
    public Integer getHitCount() {
        return hitCount;
    }

    public void setHitCount(Integer hitCount) {
        this.hitCount = hitCount;
    }
    public String getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(String isRecommend) {
        this.isRecommend = isRecommend;
    }
    public String getCreateUserCity() {
        return createUserCity;
    }

    public void setCreateUserCity(String createUserCity) {
        this.createUserCity = createUserCity;
    }
    public String getCreateUserSchoolId() {
        return createUserSchoolId;
    }

    public void setCreateUserSchoolId(String createUserSchoolId) {
        this.createUserSchoolId = createUserSchoolId;
    }
    public String getLiveScope() {
        return liveScope;
    }

    public void setLiveScope(String liveScope) {
        this.liveScope = liveScope;
    }
    public String getDisContentmd5() {
        return disContentmd5;
    }

    public void setDisContentmd5(String disContentmd5) {
        this.disContentmd5 = disContentmd5;
    }

    @Override
    public String toString() {
        return "ResourceContents{" +
            "Id=" + Id +
            ", name=" + name +
            ", teacherName=" + teacherName +
            ", city=" + city +
            ", schoolType=" + schoolType +
            ", school=" + school +
            ", studySection=" + studySection +
            ", course=" + course +
            ", press=" + press +
            ", volume=" + volume +
            ", contentsName=" + contentsName +
            ", createUserId=" + createUserId +
            ", createTime=" + createTime +
            ", appendix=" + appendix +
            ", resource=" + resource +
            ", introduction=" + introduction +
            ", status=" + status +
            ", resourceType=" + resourceType +
            ", resourceClassify=" + resourceClassify +
            ", type=" + type +
            ", picUrl=" + picUrl +
            ", contentsNameId=" + contentsNameId +
            ", hitCount=" + hitCount +
            ", isRecommend=" + isRecommend +
            ", createUserCity=" + createUserCity +
            ", createUserSchoolId=" + createUserSchoolId +
            ", liveScope=" + liveScope +
            ", disContentmd5=" + disContentmd5 +
        "}";
    }
}
