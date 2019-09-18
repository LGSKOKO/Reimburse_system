package com.lgs.dao;

import com.lgs.entity.Department;
import com.lgs.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//employee实体类的持久化操作接口 持久层
//将其添加到IOC容器里 因为使用jdk动态代理 所以是接口
@Repository("employeeDao")
public interface EmployeeDao {

    void insert(Employee employee);//插入操作
    void update(Employee employee);//更新操作
    void delete(String sn);//删除操作
    Employee select(String sn);//查询单条记录
    List<Employee> selectAll();//查询所有记录
    List<Employee> selectByDepartmentAndPost(@Param("dsn") String dsn, @Param("post") String post);
}
