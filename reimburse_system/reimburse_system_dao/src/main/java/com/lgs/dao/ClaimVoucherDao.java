package com.lgs.dao;

import com.lgs.entity.ClaimVoucher;
import org.springframework.stereotype.Repository;

import java.util.List;

//报销单接口
@Repository("claimVoucherDao")
public interface ClaimVoucherDao {

    void insert(ClaimVoucher claimVoucher);
    void update(ClaimVoucher claimVoucher);
    void delete(int id);
    ClaimVoucher select(int id);
    //查询由某个创建者创建的报销单 参数是 创建者的编号
    List<ClaimVoucher> selectByCreateSn(String csn);
    //查询某个处理者可以处理的保险单 参数是 处理者的编号
    List<ClaimVoucher> selectByNextDealSn(String ndsn);
}
