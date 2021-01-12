package com.offon.department.service.impl;

import com.offon.department.bean.Employee;
import com.offon.department.dao.EmployeeDao;
import com.offon.department.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceimpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getEmp() {

        return employeeDao.findallEmp();
    }

    @Override
    public boolean instertEmp(Employee employee) {
        int emp = employeeDao.insertEmp(employee);
        if (emp==1){
            return true;
        }
        return false;
    }
    @Override
    public boolean update() {

        return false;
    }
    @Override
    public boolean delete(Integer id) {
        int empById = employeeDao.deleteEmpById(id);
        if (empById==1){
            return true;
        }
        return false;
    }


}
