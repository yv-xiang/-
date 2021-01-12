package com.offon.department.servlet;

import com.offon.department.bean.Employee;
import com.offon.department.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
    @Autowired
    private EmployeeService employeeService;

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Employee> emp = employeeService.getEmp();
        for (Employee employee:emp){
            System.out.println(employee);
        }
    }
}
