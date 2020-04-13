package com.ch.vm.stAction.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 教师学生行为表
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-08
 */
@TableName("vm_st_action")
@ApiModel(value="StAction对象", description="教师学生行为表")
public class StAction implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "课程题目")
    private String kctm;

    @ApiModelProperty(value = "课件切换次数")
    private String kjqhcs;

    @ApiModelProperty(value = "课件切换时间")
    private String kjqhsj;

    @ApiModelProperty(value = "录播结束时间")
    private String lbjssj;

    @ApiModelProperty(value = "录播开始时间")
    private String lbkssj;

    @ApiModelProperty(value = "录播主机ip")
    private String lbzjip;

    @ApiModelProperty(value = "老师到学生区域次数")
    private String lsdxsqycs;

    @ApiModelProperty(value = "老师到学生区域时间")
    private String lsdxsqysj;

    @ApiModelProperty(value = "老师上讲台时间")
    private String lssjtsj;

    @ApiModelProperty(value = "老师下讲台次数")
    private String lsxjtcs;

    @ApiModelProperty(value = "老师下讲台时间")
    private String lsxjtsj;

    @ApiModelProperty(value = "授课人")
    private String skr;

    @ApiModelProperty(value = "授课人单位")
    private String skrdw;

    @ApiModelProperty(value = "学段")
    private String xueduan;

    @ApiModelProperty(value = "学科")
    private String xueke;

    @ApiModelProperty(value = "出版社")
    private String chubanshe;

    @ApiModelProperty(value = "册别")
    private String cebie;

    @ApiModelProperty(value = "学生上讲台次数")
    private String xssjtcs;

    @ApiModelProperty(value = "学生站起次数")
    private String xszqcs;

    @ApiModelProperty(value = "学生上讲台时间")
    private String xssjtsj;

    @ApiModelProperty(value = "学生站起时间")
    private String xszqsj;

    @ApiModelProperty(value = "课程总时间")
    private String kczsj;

    private String rsid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getKctm() {
        return kctm;
    }

    public void setKctm(String kctm) {
        this.kctm = kctm;
    }
    public String getKjqhcs() {
        return kjqhcs;
    }

    public void setKjqhcs(String kjqhcs) {
        this.kjqhcs = kjqhcs;
    }
    public String getKjqhsj() {
        return kjqhsj;
    }

    public void setKjqhsj(String kjqhsj) {
        this.kjqhsj = kjqhsj;
    }
    public String getLbjssj() {
        return lbjssj;
    }

    public void setLbjssj(String lbjssj) {
        this.lbjssj = lbjssj;
    }
    public String getLbkssj() {
        return lbkssj;
    }

    public void setLbkssj(String lbkssj) {
        this.lbkssj = lbkssj;
    }
    public String getLbzjip() {
        return lbzjip;
    }

    public void setLbzjip(String lbzjip) {
        this.lbzjip = lbzjip;
    }
    public String getLsdxsqycs() {
        return lsdxsqycs;
    }

    public void setLsdxsqycs(String lsdxsqycs) {
        this.lsdxsqycs = lsdxsqycs;
    }
    public String getLsdxsqysj() {
        return lsdxsqysj;
    }

    public void setLsdxsqysj(String lsdxsqysj) {
        this.lsdxsqysj = lsdxsqysj;
    }
    public String getLssjtsj() {
        return lssjtsj;
    }

    public void setLssjtsj(String lssjtsj) {
        this.lssjtsj = lssjtsj;
    }
    public String getLsxjtcs() {
        return lsxjtcs;
    }

    public void setLsxjtcs(String lsxjtcs) {
        this.lsxjtcs = lsxjtcs;
    }
    public String getLsxjtsj() {
        return lsxjtsj;
    }

    public void setLsxjtsj(String lsxjtsj) {
        this.lsxjtsj = lsxjtsj;
    }
    public String getSkr() {
        return skr;
    }

    public void setSkr(String skr) {
        this.skr = skr;
    }
    public String getSkrdw() {
        return skrdw;
    }

    public void setSkrdw(String skrdw) {
        this.skrdw = skrdw;
    }
    public String getXueduan() {
        return xueduan;
    }

    public void setXueduan(String xueduan) {
        this.xueduan = xueduan;
    }
    public String getXueke() {
        return xueke;
    }

    public void setXueke(String xueke) {
        this.xueke = xueke;
    }
    public String getChubanshe() {
        return chubanshe;
    }

    public void setChubanshe(String chubanshe) {
        this.chubanshe = chubanshe;
    }
    public String getCebie() {
        return cebie;
    }

    public void setCebie(String cebie) {
        this.cebie = cebie;
    }
    public String getXssjtcs() {
        return xssjtcs;
    }

    public void setXssjtcs(String xssjtcs) {
        this.xssjtcs = xssjtcs;
    }
    public String getXszqcs() {
        return xszqcs;
    }

    public void setXszqcs(String xszqcs) {
        this.xszqcs = xszqcs;
    }
    public String getXssjtsj() {
        return xssjtsj;
    }

    public void setXssjtsj(String xssjtsj) {
        this.xssjtsj = xssjtsj;
    }
    public String getXszqsj() {
        return xszqsj;
    }

    public void setXszqsj(String xszqsj) {
        this.xszqsj = xszqsj;
    }
    public String getKczsj() {
        return kczsj;
    }

    public void setKczsj(String kczsj) {
        this.kczsj = kczsj;
    }
    public String getRsid() {
        return rsid;
    }

    public void setRsid(String rsid) {
        this.rsid = rsid;
    }

    @Override
    public String toString() {
        return "StAction{" +
            "id=" + id +
            ", kctm=" + kctm +
            ", kjqhcs=" + kjqhcs +
            ", kjqhsj=" + kjqhsj +
            ", lbjssj=" + lbjssj +
            ", lbkssj=" + lbkssj +
            ", lbzjip=" + lbzjip +
            ", lsdxsqycs=" + lsdxsqycs +
            ", lsdxsqysj=" + lsdxsqysj +
            ", lssjtsj=" + lssjtsj +
            ", lsxjtcs=" + lsxjtcs +
            ", lsxjtsj=" + lsxjtsj +
            ", skr=" + skr +
            ", skrdw=" + skrdw +
            ", xueduan=" + xueduan +
            ", xueke=" + xueke +
            ", chubanshe=" + chubanshe +
            ", cebie=" + cebie +
            ", xssjtcs=" + xssjtcs +
            ", xszqcs=" + xszqcs +
            ", xssjtsj=" + xssjtsj +
            ", xszqsj=" + xszqsj +
            ", kczsj=" + kczsj +
            ", rsid=" + rsid +
        "}";
    }
}
