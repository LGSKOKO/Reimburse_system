package com.lgs.biz;

import com.lgs.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

//Department的业务层接口
public interface DepartmentBiz {

    //添加部门
    void add(Department department);
    //修改部门
    void edit(Department department);
    //删除部门
    void remove(String sn);
    //获得单个部门
    Department get(String sn);
    //获得所以部门
    List<Department> getAll();
}
