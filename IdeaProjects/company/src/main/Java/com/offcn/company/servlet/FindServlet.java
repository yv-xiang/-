package com.offcn.company.servlet;

import com.offcn.company.Service.CompanyService;
import com.offcn.company.bean.Company;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {
    @Autowired
    CompanyService companyService;

    public CompanyService getCompanyService() {
        return companyService;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        HttpSession session =request.getSession();
        List<Company> find = companyService.getFind();
        request.setAttribute("find",find);
        for (Company company:find){
            System.out.println(company);
        }
        request.getRequestDispatcher("/home.jsp").forward(request,response);



    }
}
