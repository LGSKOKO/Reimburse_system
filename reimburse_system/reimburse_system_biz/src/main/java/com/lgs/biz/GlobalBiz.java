package com.lgs.biz;

import com.lgs.entity.Employee;

// 登录和个人中心先关操作的接口
public interface GlobalBiz {

    //登录方法:需要传账号(编号)和密码,并返回相关对象
    Employee login(String sn,String password);
    //修改密码操作
    void changPassword(Employee employee);
}
