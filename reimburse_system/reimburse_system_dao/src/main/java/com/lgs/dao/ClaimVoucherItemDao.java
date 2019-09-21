package com.lgs.dao;

import com.lgs.entity.ClaimVoucherItem;
import org.springframework.stereotype.Repository;

import java.util.List;

//报销单条目接口
@Repository("claimVoucherItemDao")
public interface ClaimVoucherItemDao {

    void insert(ClaimVoucherItem claimVoucherItem);
    void update(ClaimVoucherItem claimVoucherItem);
    void delete(int id);
    //通过报销单号 查询其对应的报销单条目
    List<ClaimVoucherItem> selectByClaimVoucher(int cvid);

}
