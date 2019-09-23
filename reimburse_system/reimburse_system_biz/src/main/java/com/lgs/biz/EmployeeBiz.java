package com.lgs.biz;

import com.lgs.entity.Employee;

import java.util.List;

//Employee的业务层接口
public interface EmployeeBiz {

    void add(Employee employee);
    void edit(Employee employee);
    void remove(String sn);
    Employee get(String sn);
    List<Employee> getAll();
}
