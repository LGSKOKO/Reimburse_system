package com.lgs.biz.impl;

import com.lgs.biz.EmployeeBiz;
import com.lgs.dao.EmployeeDao;
import com.lgs.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：李先生
 * @date ：Created in 2019/8/20 17:28
 * @description：EmployeeBiz接口的实现类 业务层
 * @modified By：
 * @version: $
 */
@Service("employeeBiz")
public class EmployeeBizImpl implements EmployeeBiz {
    @Autowired
    private EmployeeDao employeeDao;
    public void add(Employee employee) {
        employee.setPassword("123456");//设置默认密码
        employeeDao.insert(employee);
    }

    public void edit(Employee employee) {
        employeeDao.update(employee);
    }

    public void remove(String sn) {
        employeeDao.delete(sn);
    }

    public Employee get(String sn) {
        return employeeDao.select(sn);
    }

    public List<Employee> getAll() {
        return employeeDao.selectAll();
    }
}
