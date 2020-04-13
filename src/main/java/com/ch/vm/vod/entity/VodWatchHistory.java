package com.ch.vm.vod.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 视频观看历史
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-08
 */
@TableName("vm_vod_watch_history")
@ApiModel(value="VodWatchHistory对象", description="视频观看历史")
public class VodWatchHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    private String uid;

    @ApiModelProperty(value = "视频id")
    private Integer vid;

    @ApiModelProperty(value = "播放时长")
    private String time;

    @ApiModelProperty(value = "日期时间")
    private String date;

    private String totaltime;

    @ApiModelProperty(value = "用户md5")
    private String disUmd5;

    @ApiModelProperty(value = "视频md5")
    private String disVmd5;

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
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getTotaltime() {
        return totaltime;
    }

    public void setTotaltime(String totaltime) {
        this.totaltime = totaltime;
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

    @Override
    public String toString() {
        return "VodWatchHistory{" +
            "uid=" + uid +
            ", vid=" + vid +
            ", time=" + time +
            ", date=" + date +
            ", totaltime=" + totaltime +
            ", disUmd5=" + disUmd5 +
            ", disVmd5=" + disVmd5 +
        "}";
    }
}
