package com.ch.vm.vod.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;

/**
 * <p>
 * 资源类别列表
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-08
 */
@TableName("vm_resource_classify")
@ApiModel(value="ResourceClassify对象", description="资源类别列表")
public class ResourceClassify implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    @TableField("resourceType")
    private Integer resourceType;

    @TableField("resourceClassify")
    private String resourceClassify;

    @TableField("createUserId")
    private String createUserId;

    @TableField("createTime")
    private String createTime;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }
    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }
    public String getResourceClassify() {
        return resourceClassify;
    }

    public void setResourceClassify(String resourceClassify) {
        this.resourceClassify = resourceClassify;
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

    @Override
    public String toString() {
        return "ResourceClassify{" +
            "Id=" + Id +
            ", resourceType=" + resourceType +
            ", resourceClassify=" + resourceClassify +
            ", createUserId=" + createUserId +
            ", createTime=" + createTime +
        "}";
    }
}
