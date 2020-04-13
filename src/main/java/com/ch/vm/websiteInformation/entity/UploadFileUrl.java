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
 * 上传目录设置
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-07
 */
@TableName("vm_upload_file_url")
@ApiModel(value="UploadFileUrl对象", description="上传目录设置")
public class UploadFileUrl implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "物理地址")
    private String url;

    @ApiModelProperty(value = "启用状态")
    @TableField("virtualPath")
    private String virtualPath;

    @ApiModelProperty(value = "标示是否有效")
    @TableField("isValid")
    private String isValid;

    @ApiModelProperty(value = "创建人id")
    @TableField("createUserId")
    private String createUserId;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private String createTime;

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
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getVirtualPath() {
        return virtualPath;
    }

    public void setVirtualPath(String virtualPath) {
        this.virtualPath = virtualPath;
    }
    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
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
        return "UploadFileUrl{" +
            "Id=" + Id +
            ", name=" + name +
            ", url=" + url +
            ", virtualPath=" + virtualPath +
            ", isValid=" + isValid +
            ", createUserId=" + createUserId +
            ", createTime=" + createTime +
        "}";
    }
}
