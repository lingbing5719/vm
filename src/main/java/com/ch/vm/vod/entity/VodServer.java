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
 * 点播地址维护
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-08
 */
@TableName("vm_vod_server")
@ApiModel(value="VodServer对象", description="点播地址维护")
public class VodServer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    @ApiModelProperty(value = "点播地址名称")
    private String name;

    @ApiModelProperty(value = "点播地址")
    private String url;

    @ApiModelProperty(value = "启用状态")
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
        return "VodServer{" +
            "Id=" + Id +
            ", name=" + name +
            ", url=" + url +
            ", isValid=" + isValid +
            ", createUserId=" + createUserId +
            ", createTime=" + createTime +
        "}";
    }
}
