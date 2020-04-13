package com.ch.vm.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ch.vm.user.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-03
 */
@TableName("vm_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "User对象", description = "用户信息表")
public class User implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    @ApiModelProperty(value = "真实姓名")
    private String name;

    @ApiModelProperty(value = "登陆名")
    private String username;

    @ApiModelProperty(value = "登陆密码")
    private String password;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "电话号码")
    private String telephone;

    @ApiModelProperty(value = "身份类型")
    private Integer identity;

    @ApiModelProperty(value = "email地址")
    private String email;

    @ApiModelProperty(value = "身份证号码")
    private String identification;

    @ApiModelProperty(value = "头像地址")
    @TableField("headSculpture")
    private String headSculpture;

    @ApiModelProperty(value = "是否可用")
    private Boolean enabled;

    @ApiModelProperty(value = "账号状态（0未审核）（1审核通过）（2审核未通过）（3禁用）")
    private String status;

    @ApiModelProperty(value = "学校id")
    @TableField("schoolId")
    private String schoolId;

    @ApiModelProperty(value = "注册时间")
    private String createtime;

    @ApiModelProperty(value = "最后登录时间")
    @TableField("lastLoginTime")
    private String lastLoginTime;

    @ApiModelProperty(value = "本次登陆时间")
    @TableField("thisLoginTime")
    private String thisLoginTime;

    @TableField("dis_createIp")
    private String disCreateip;

    @ApiModelProperty(value = "学校名称")
    private String disSchool;

    @ApiModelProperty(value = "学校类型")
    private String disSchooltype;

    @ApiModelProperty(value = "县市区")
    private String disCitys;

    @ApiModelProperty(value = "用户md5")
    @TableField("dis_userMd5")
    private String disUsermd5;

    @ApiModelProperty(value = "拥有的权限")
    @TableField("dis_groupName")
    private String disGroupname;

    @ApiModelProperty(value = "城市id")
    @TableField("dis_cityId")
    private String disCityid;

    @ApiModelProperty(value = "权限名称")
    @TableField("dis_privilegeId")
    private String disPrivilegeid;

    @JsonIgnore
    @TableField(exist = false)
    private List<Role> roles;

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

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        try {
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }
            return authorities;
        } catch (Exception e){

        }
        return null;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getHeadSculpture() {
        return headSculpture;
    }

    public void setHeadSculpture(String headSculpture) {
        this.headSculpture = headSculpture;
    }


    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getThisLoginTime() {
        return thisLoginTime;
    }

    public void setThisLoginTime(String thisLoginTime) {
        this.thisLoginTime = thisLoginTime;
    }

    public String getDisCreateip() {
        return disCreateip;
    }

    public void setDisCreateip(String disCreateip) {
        this.disCreateip = disCreateip;
    }

    public String getDisSchool() {
        return disSchool;
    }

    public void setDisSchool(String disSchool) {
        this.disSchool = disSchool;
    }

    public String getDisSchooltype() {
        return disSchooltype;
    }

    public void setDisSchooltype(String disSchooltype) {
        this.disSchooltype = disSchooltype;
    }

    public String getDisCitys() {
        return disCitys;
    }

    public void setDisCitys(String disCitys) {
        this.disCitys = disCitys;
    }

    public String getDisUsermd5() {
        return disUsermd5;
    }

    public void setDisUsermd5(String disUsermd5) {
        this.disUsermd5 = disUsermd5;
    }

    public String getDisGroupname() {
        return disGroupname;
    }

    public void setDisGroupname(String disGroupname) {
        this.disGroupname = disGroupname;
    }

    public String getDisCityid() {
        return disCityid;
    }

    public void setDisCityid(String disCityid) {
        this.disCityid = disCityid;
    }

    public String getDisPrivilegeid() {
        return disPrivilegeid;
    }

    public void setDisPrivilegeid(String disPrivilegeid) {
        this.disPrivilegeid = disPrivilegeid;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name=" + name +
                ", username=" + username +
                ", password=" + password +
                ", sex=" + sex +
                ", telephone=" + telephone +
                ", identity=" + identity +
                ", email=" + email +
                ", identification=" + identification +
                ", headSculpture=" + headSculpture +
                ", enabled=" + enabled +
                ", status=" + status +
                ", schoolId=" + schoolId +
                ", createtime=" + createtime +
                ", lastLoginTime=" + lastLoginTime +
                ", thisLoginTime=" + thisLoginTime +
                ", disCreateip=" + disCreateip +
                ", disSchool=" + disSchool +
                ", disSchooltype=" + disSchooltype +
                ", disCitys=" + disCitys +
                ", disUsermd5=" + disUsermd5 +
                ", disGroupname=" + disGroupname +
                ", disCityid=" + disCityid +
                ", disPrivilegeid=" + disPrivilegeid +
                "}";
    }
}
