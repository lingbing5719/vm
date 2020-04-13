package com.ch.vm.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户身份列表
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-03
 */
@TableName("vm_user_type")
@ApiModel(value="UserType对象", description="用户身份列表")
public class UserType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "身份名称")
    private String name;

    @ApiModelProperty(value = "创建人id")
    @TableField("createUserId")
    private String createUserId;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "UserType{" +
            "id=" + id +
            ", name=" + name +
            ", createUserId=" + createUserId +
            ", createTime=" + createTime +
        "}";
    }
}
