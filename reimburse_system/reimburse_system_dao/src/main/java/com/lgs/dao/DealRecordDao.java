package com.lgs.dao;

import com.lgs.entity.DealRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

//报销单处理记录接口
@Repository("dealRecordDao")
public interface DealRecordDao {
    //因为是记录报销单的一些操作记录
    //所以不存在可以删除 和 修改记录的功能
    void insert(DealRecord dealRecord);
    //通过报销单号 查询其对应的处理记录
    List<DealRecord> selectByClaimVoucher(int cvid);
}
