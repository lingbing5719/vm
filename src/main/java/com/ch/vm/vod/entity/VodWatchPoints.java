package com.ch.vm.vod.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 点播资源打点
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-08
 */
@TableName("vm_vod_watch_points")
@ApiModel(value="VodWatchPoints对象", description="点播资源打点")
public class VodWatchPoints implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "打点人id")
    private String uid;

    @ApiModelProperty(value = "打点视频id")
    private Integer vid;

    @ApiModelProperty(value = "打点视频播放时间秒")
    private String k;

    @ApiModelProperty(value = "打点内容")
    private String n;

    @ApiModelProperty(value = "用户md5")
    private String disUmd5;

    @ApiModelProperty(value = "视频md5")
    private String disVmd5;

    @ApiModelProperty(value = "打点时间")
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }
    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }
    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }
    public String getDisUmd5() {
        return disUmd5;
    }

    public void setDisUmd5(String disUmd5) {
        this.disUmd5 = disUmd5;
    }
    public String getDisVmd5() {
        return disVmd5;
    }

    public void setDisVmd5(String disVmd5) {
        this.disVmd5 = disVmd5;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "VodWatchPoints{" +
            "id=" + id +
            ", uid=" + uid +
            ", vid=" + vid +
            ", k=" + k +
            ", n=" + n +
            ", disUmd5=" + disUmd5 +
            ", disVmd5=" + disVmd5 +
            ", time=" + time +
        "}";
    }
}
