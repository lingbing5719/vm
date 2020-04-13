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
 * 站点信息
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-07
 */
@TableName("vm_site")
@ApiModel(value="Site对象", description="站点信息")
public class Site implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "站点名称")
    private String sitename;

    @ApiModelProperty(value = "备案编号")
    @TableField("KeepOnrecord")
    private String KeepOnrecord;

    @ApiModelProperty(value = "版权信息")
    private String copyright;

    @ApiModelProperty(value = "页脚声明")
    private String footer;

    @ApiModelProperty(value = "联系方式")
    private String contact;

    @ApiModelProperty(value = "logo图片")
    private String logo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }
    public String getKeepOnrecord() {
        return KeepOnrecord;
    }

    public void setKeepOnrecord(String KeepOnrecord) {
        this.KeepOnrecord = KeepOnrecord;
    }
    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Site{" +
            "id=" + id +
            ", sitename=" + sitename +
            ", KeepOnrecord=" + KeepOnrecord +
            ", copyright=" + copyright +
            ", footer=" + footer +
            ", contact=" + contact +
            ", logo=" + logo +
        "}";
    }
}
