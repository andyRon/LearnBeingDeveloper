package com.andyron.cache.service;

import com.andyron.cache.bean.Employee;
import com.andyron.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Andy Ron
 */
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public Employee getEmp(Integer id) {
        System.out.println("查询" + id + "号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;

    }
}
