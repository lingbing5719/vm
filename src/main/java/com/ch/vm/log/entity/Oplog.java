package com.ch.vm.log.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 操作日志
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-07
 */
@TableName("vm_oplog")
@ApiModel(value="Oplog对象", description="操作日志")
public class Oplog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "添加日期")
    @TableField("addDate")
    private Date addDate;

    @ApiModelProperty(value = "操作内容")
    private String operate;

    @ApiModelProperty(value = "操作员ID")
    private Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Oplog{" +
            "id=" + id +
            ", addDate=" + addDate +
            ", operate=" + operate +
            ", userid=" + userid +
        "}";
    }
}
