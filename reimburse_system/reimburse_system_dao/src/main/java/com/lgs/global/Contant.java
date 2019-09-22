package com.lgs.global;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：李先生
 * @date ：Created in 2019/8/18 22:57
 * @description：常量类  作为数据字典
 * @modified By：
 * @version: $
 */
public class Contant {

    //职务
    public static final String POST_STAFF = "员工";
    public static final String POST_FM = "部门经理";
    public static final String POST_GM = "总经理";
    public static final String POST_CASHIER = "财务";
    //声明一个方法返回这些职务的集合 可用于在登陆时的选择身份
    public static List<String> getPosts(){
        List<String> list = new ArrayList<String>();
        list.add(POST_STAFF);
        list.add(POST_FM);
        list.add(POST_GM);
        list.add(POST_CASHIER);
        return list;
    }

    //费用类型
    public static List<String> getItems(){
        List<String> list = new ArrayList<String>();
        list.add("交通");
        list.add("餐饮");
        list.add("住宿");
        list.add("办公");
        return list;
    }

    //报销单状态
    public static final String CLAIMVOUCHER_CREATED = "新创建";
    public static final String CLAIMVOUCHER_SUBMIT = "已提交";
    public static final String CLAIMVOUCHER_APPROVED = "已审核";
    public static final String CLAIMVOUCHER_BACK = "已打回";
    public static final String CLAIMVOUCHER_TERMINATED = "已终止";
    public static final String CLAIMVOUCHER_RECHECK = "待复审";
    public static final String CLAIMVOUCHER_PAID = "已审核";

    //审核额度
    public static final double LIMIT_CHECK = 5000.00;

    //处理方式
    public static final String DEAL_CREATE = "创建";
    public static final String DEAL_SUBMIT = "提交";
    public static final String DEAL_UPDATE = "更新";
    public static final String DEAL_BACK = "打回";
    public static final String DEAL_REJECT = "拒绝";
    public static final String DEAL_PASS = "通过";
    public static final String DEAL_PAID = "打款";

}
