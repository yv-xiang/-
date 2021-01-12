package com.offcn.company.servlet;

import com.offcn.company.Service.CompanyService;
import com.offcn.company.bean.Company;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/OneServlet")
public class OneServlet extends HttpServlet {
    @Autowired
    private CompanyService companyService;

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

        int tid = Integer.parseInt(request.getParameter("tid"));
        Company company = companyService.find(tid);
        request.setAttribute("company",company);
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }
}
