package com.lgs.biz.impl;

import com.lgs.biz.ClaimVoucherBiz;
import com.lgs.dao.ClaimVoucherDao;
import com.lgs.dao.ClaimVoucherItemDao;
import com.lgs.dao.DealRecordDao;
import com.lgs.dao.EmployeeDao;
import com.lgs.entity.ClaimVoucher;
import com.lgs.entity.ClaimVoucherItem;
import com.lgs.entity.DealRecord;
import com.lgs.entity.Employee;
import com.lgs.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//报销单业务层的接口的实现类
@Service("claimVoucherBiz")
public class ClaimVoucherBizImpl implements ClaimVoucherBiz {
    @Autowired
    private ClaimVoucherDao claimVoucherDao;
    @Autowired
    private ClaimVoucherItemDao claimVoucherItemDao;
    @Autowired
    private DealRecordDao dealRecordDao;
    @Autowired
    private EmployeeDao employeeDao;

    public void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items) {
        claimVoucher.setCreateTime(new Date());
        claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
        claimVoucher.setStatus(Contant.CLAIMVOUCHER_CREATED);
        claimVoucherDao.insert(claimVoucher);

        for(ClaimVoucherItem item:items){
            item.setClaimVoucherId(claimVoucher.getId());
            claimVoucherItemDao.insert(item);
        }
    }

    public ClaimVoucher get(int id) {
        return claimVoucherDao.select(id);
    }

    public List<ClaimVoucherItem> getItems(int cvid) {
        return claimVoucherItemDao.selectByClaimVoucher(cvid);
    }

    public List<DealRecord> getRecords(int cvid) {
        return dealRecordDao.selectByClaimVoucher(cvid);
    }

    public List<ClaimVoucher> getForSelf(String sn) {
        return claimVoucherDao.selectByCreateSn(sn);
    }

    public List<ClaimVoucher> getForDeal(String sn) {
        return claimVoucherDao.selectByNextDealSn(sn);
    }

    public void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items) {
        claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
        claimVoucher.setStatus(Contant.CLAIMVOUCHER_CREATED);
        claimVoucherDao.update(claimVoucher);

        List<ClaimVoucherItem> olds = claimVoucherItemDao.selectByClaimVoucher(claimVoucher.getId());
        for(ClaimVoucherItem old:olds){
            boolean isHave=false;
            for(ClaimVoucherItem item:items){
                if(item.getId()==old.getId()){
                    isHave=true;
                    break;
                }
            }
            if(!isHave){
                claimVoucherItemDao.delete(old.getId());
            }
        }
        for(ClaimVoucherItem item:items){
            item.setClaimVoucherId(claimVoucher.getId());
            if(item.getId()>0){
                claimVoucherItemDao.update(item);
            }else{
                claimVoucherItemDao.insert(item);
            }
        }

    }

    public void submit(int id) {
        ClaimVoucher claimVoucher = claimVoucherDao.select(id);
        Employee employee = employeeDao.select(claimVoucher.getCreateSn());

        claimVoucher.setStatus(Contant.CLAIMVOUCHER_SUBMIT);
        claimVoucher.setNextDealSn(employeeDao.selectByDepartmentAndPost(employee.getDepartmentSn(),Contant.POST_FM).get(0).getSn());
        claimVoucherDao.update(claimVoucher);

        DealRecord dealRecord = new DealRecord();
        dealRecord.setDealWay(Contant.DEAL_SUBMIT);
        dealRecord.setDealSn(employee.getSn());
        dealRecord.setClaimVoucherId(id);
        dealRecord.setDealResult(Contant.CLAIMVOUCHER_SUBMIT);
        dealRecord.setDealTime(new Date());
        dealRecord.setComment("无");
        dealRecordDao.insert(dealRecord);
    }

    public void deal(DealRecord dealRecord) {
        ClaimVoucher claimVoucher = claimVoucherDao.select(dealRecord.getClaimVoucherId());
        Employee employee = employeeDao.select(dealRecord.getDealSn());
        //因为下面都需要设置处理时间 这里放在开头 就省去了重复的代码
        dealRecord.setDealTime(new Date());

        if(dealRecord.getDealWay().equals(Contant.DEAL_PASS)){//审核通过
            //不需要复审的情况
            if(claimVoucher.getTotalAmount()<=Contant.LIMIT_CHECK || employee.getPost().equals(Contant.POST_GM)){
                claimVoucher.setStatus(Contant.CLAIMVOUCHER_APPROVED);
                claimVoucher.setNextDealSn(employeeDao.selectByDepartmentAndPost(null,Contant.POST_CASHIER).get(0).getSn());

                dealRecord.setDealResult(Contant.CLAIMVOUCHER_APPROVED);
            }else{//需要复审的情况
                claimVoucher.setStatus(Contant.CLAIMVOUCHER_RECHECK);
                claimVoucher.setNextDealSn(employeeDao.selectByDepartmentAndPost(null,Contant.POST_GM).get(0).getSn());

                dealRecord.setDealResult(Contant.CLAIMVOUCHER_RECHECK);
            }
            //打回操作
        }else if(dealRecord.getDealWay().equals(Contant.DEAL_BACK)){
            claimVoucher.setStatus(Contant.CLAIMVOUCHER_BACK);
            claimVoucher.setNextDealSn(claimVoucher.getCreateSn());

            dealRecord.setDealResult(Contant.CLAIMVOUCHER_BACK);
            //拒绝状态
        }else if(dealRecord.getDealWay().equals(Contant.DEAL_REJECT)){
            claimVoucher.setStatus(Contant.CLAIMVOUCHER_TERMINATED);//报销单为终止状态 无效
            claimVoucher.setNextDealSn(null);//待处理人为null

            dealRecord.setDealResult(Contant.CLAIMVOUCHER_TERMINATED);//报销单为终止状态 无效
            //已打款
        }else if(dealRecord.getDealWay().equals(Contant.DEAL_PAID)){
            claimVoucher.setStatus(Contant.CLAIMVOUCHER_PAID);
            claimVoucher.setNextDealSn(null);

            dealRecord.setDealResult(Contant.CLAIMVOUCHER_PAID);
        }

        claimVoucherDao.update(claimVoucher);
        dealRecordDao.insert(dealRecord);
    }

}
