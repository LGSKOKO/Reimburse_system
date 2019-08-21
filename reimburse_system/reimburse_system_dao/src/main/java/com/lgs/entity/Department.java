package com.lgs.entity;

/**
 * @author ：李先生
 * @date ：Created in 2019/8/20 15:46
 * @description：部门实体类 与数据库对应的表相对应
 * @modified By：
 * @version: $
 */
public class Department {
    private String sn;
    private String name;
    private String address;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
