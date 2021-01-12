package com.offon.department.servlet;

import com.offon.department.bean.Employee;
import com.offon.department.service.EmployeeService;
import com.offon.department.service.impl.EmployeeServiceimpl;
import com.offon.department.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    @Autowired
    private EmployeeService employeeService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String registerDate = request.getParameter("registerDate");
        int dept_id = Integer.parseInt(request.getParameter("dept_id"));
        Employee employee = new Employee();
        employee.setName(name);
        employee.setRegisterDate(DateUtil.strToDate(registerDate));
        employee.setDept_id(dept_id);
        EmployeeService employeeService = new EmployeeServiceimpl();
        employeeService.instertEmp(employee);


    }
}
