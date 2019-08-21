package com.lgs.dao;

import com.lgs.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

//Department实体类的持久化操作接口 持久层
//将其添加到IOC容器里 因为使用jdk动态代理 所以是接口
@Repository("departmentDao")
public interface DepartmentDao {

    void insert(Department department);//插入操作
    void update(Department department);//更新操作
    void delete(String sn);//删除操作
    Department select(String sn);//查询单条记录
    List<Department> selectAll();//查询所有记录
}
