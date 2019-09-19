package com.lgs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author ：李先生
 * @date ：Created in 2019/8/31 16:48
 * @description：有关于报销单 处理记录的实体类
 * @modified By：
 * @version: $
 */
public class DealRecord {

    private Integer id;//编号
    private Integer claimVoucherId;//报销单编号
    private String dealSn;//处理人编号
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date dealTime;//处理时间
    private String dealWay;//处理类型
    private String dealResult;//处理结果
    private String comment;//备注

    private Employee dealer;//处理人 因为表现层是显示处理人而不是处理人编号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClaimVoucherId() {
        return claimVoucherId;
    }

    public void setClaimVoucherId(Integer claimVoucherId) {
        this.claimVoucherId = claimVoucherId;
    }

    public String getDealSn() {
        return dealSn;
    }

    public void setDealSn(String dealSn) {
        this.dealSn = dealSn;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public String getDealWay() {
        return dealWay;
    }

    public void setDealWay(String dealWay) {
        this.dealWay = dealWay;
    }

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Employee getDealer() {
        return dealer;
    }

    public void setDealer(Employee dealer) {
        this.dealer = dealer;
    }
}
