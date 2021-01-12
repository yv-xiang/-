package com.offon.department.service;

import com.offon.department.bean.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getEmp();
    public boolean instertEmp(Employee employee);
    public boolean update();
    public boolean delete(Integer id);

}
