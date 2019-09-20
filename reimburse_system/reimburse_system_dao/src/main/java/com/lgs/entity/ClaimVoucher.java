package com.lgs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author ：李先生
 * @date ：Created in 2019/8/31 16:55
 * @description：报销单实体类
 * @modified By：
 * @version: $
 */
public class ClaimVoucher {

    private Integer id;//编号
    private String cause;//事由
    private String createSn;//创建人编号
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date createTime;//创建时间
    private String nextDealSn;//待处理人编号
    private Double totalAmount;//总金额
    private String status;//状态

    private Employee creater;//创建人 因为表现层是显示创建人而不是创建人编号
    private Employee dealer;//处理人 因为表现层是显示处理人而不是处理人编号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getCreateSn() {
        return createSn;
    }

    public void setCreateSn(String createSn) {
        this.createSn = createSn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNextDealSn() {
        return nextDealSn;
    }

    public void setNextDealSn(String nextDealSn) {
        this.nextDealSn = nextDealSn;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getCreater() {
        return creater;
    }

    public void setCreater(Employee creater) {
        this.creater = creater;
    }

    public Employee getDealer() {
        return dealer;
    }

    public void setDealer(Employee dealer) {
        this.dealer = dealer;
    }
}
