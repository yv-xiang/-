package com.offon.department.dao;

import com.offon.department.bean.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findallEmp();
    public int insertEmp(Employee employee);
    public int updateEmp(Employee employee);
    public int deleteEmpById(Integer id);


}
