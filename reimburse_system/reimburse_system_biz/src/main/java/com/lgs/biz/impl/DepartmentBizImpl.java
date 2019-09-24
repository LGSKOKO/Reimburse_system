package com.lgs.biz.impl;

import com.lgs.biz.DepartmentBiz;
import com.lgs.dao.DepartmentDao;
import com.lgs.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：李先生
 * @date ：Created in 2019/8/20 17:28
 * @description：DepartmentBiz接口的实现类 业务层
 * @modified By：
 * @version: $
 */
@Service("departmentBiz")
public class DepartmentBizImpl implements DepartmentBiz {
    @Autowired
    private DepartmentDao departmentDao;
    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public void remove(String sn) {
        departmentDao.delete(sn);
    }

    public Department get(String sn) {
        return departmentDao.select(sn);
    }

    public List<Department> getAll() {
        return departmentDao.selectAll();
    }
}
