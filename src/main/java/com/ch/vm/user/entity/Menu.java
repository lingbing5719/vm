package com.ch.vm.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 菜单信息
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-03
 */
@TableName("vm_menu")
@ApiModel(value = "Menu对象", description = "菜单信息")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "资源链接")
    private String url;

    @ApiModelProperty(value = "资源名称")
    private String name;

    @TableField("iconCls")
    private String iconCls;

    @ApiModelProperty(value = "父id")
    @TableField("parentId")
    private Integer parentId;

    @ApiModelProperty(value = "是否可用")
    private Boolean enabled;

    @ApiModelProperty(value = "链接名称")
    private String disPath;

    private String disComponent;

    @TableField("dis_keepAlive")
    private Boolean disKeepalive;

    @TableField("dis_requireAuth")
    private Boolean disRequireauth;


    private List<com.ch.vm.user.entity.Role> roles;
    private List<com.ch.vm.user.entity.Menu> children;

    @JsonIgnore
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getDisPath() {
        return disPath;
    }

    public void setDisPath(String disPath) {
        this.disPath = disPath;
    }

    public String getDisComponent() {
        return disComponent;
    }

    public void setDisComponent(String disComponent) {
        this.disComponent = disComponent;
    }

    public Boolean getDisKeepalive() {
        return disKeepalive;
    }

    public void setDisKeepalive(Boolean disKeepalive) {
        this.disKeepalive = disKeepalive;
    }

    public Boolean getDisRequireauth() {
        return disRequireauth;
    }

    public void setDisRequireauth(Boolean disRequireauth) {
        this.disRequireauth = disRequireauth;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", url=" + url +
                ", name=" + name +
                ", iconCls=" + iconCls +
                ", parentId=" + parentId +
                ", enabled=" + enabled +
                ", disPath=" + disPath +
                ", disComponent=" + disComponent +
                ", disKeepalive=" + disKeepalive +
                ", disRequireauth=" + disRequireauth +
                "}";
    }
}
