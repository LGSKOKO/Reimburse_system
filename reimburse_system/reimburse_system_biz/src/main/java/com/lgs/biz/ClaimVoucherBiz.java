package com.lgs.biz;

import com.lgs.entity.ClaimVoucher;
import com.lgs.entity.ClaimVoucherItem;
import com.lgs.entity.DealRecord;

import java.util.List;
//报销单业务层的接口
public interface ClaimVoucherBiz {

    void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);

    ClaimVoucher get(int id);
    List<ClaimVoucherItem> getItems(int cvid);
    List<DealRecord> getRecords(int cvid);

    List<ClaimVoucher> getForSelf(String sn);
    List<ClaimVoucher> getForDeal(String sn);

    void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);
    void submit(int id);
    void deal(DealRecord dealRecord);
}
