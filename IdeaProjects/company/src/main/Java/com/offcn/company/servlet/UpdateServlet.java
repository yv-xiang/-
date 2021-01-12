package com.offcn.company.servlet;

import com.offcn.company.Service.CompanyService;
import com.offcn.company.bean.Company;
import com.offcn.company.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
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

        request.setCharacterEncoding("utf8");
        int tid = Integer.parseInt(request.getParameter("tid"));
        String tname = request.getParameter("tname");
        String tsex = request.getParameter("tsex");
        Date tregisterDate = DateUtil.strToDate(request.getParameter("tregisterDate"));
        int tdeptId = Integer.parseInt(request.getParameter("tdeptId"));
        Company company = new Company();
        company.setTid(tid);
        company.setTname(tname);
        company.setTsex(tsex);
        company.setTregisterDate(tregisterDate);
        company.setTdeptId(tdeptId);
        request.setAttribute("company",company);
        boolean updateCom = companyService.UpdateCom(company);
        if (updateCom){
           request.getRequestDispatcher("/FindServlet").forward(request,response);
        }else {
            request.getRequestDispatcher("/OneServlet").forward(request, response);
        }
        return;
    }
}
