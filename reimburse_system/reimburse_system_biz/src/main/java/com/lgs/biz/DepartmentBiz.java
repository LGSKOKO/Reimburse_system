package com.lgs.biz;

import com.lgs.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

//Department的业务层接口
public interface DepartmentBiz {

    void add(Department department);
    void edit(Department department);
    void remove(String sn);
    Department get(String sn);
    List<Department> getAll();
}
