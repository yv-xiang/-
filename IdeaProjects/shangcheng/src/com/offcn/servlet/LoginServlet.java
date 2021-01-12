package com.offcn.servlet;

import com.offcn.bean.User;
import com.offcn.service.UserService;
import com.offcn.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService userService = new UserServiceImpl();
        User user = userService.findUserandpassword(username, password);
        if ( user != null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("/ProductServlet");
            System.out.println("登录成功！");
        }else {
            response.sendRedirect("jsp/login.jsp?msg=loginner");
            System.out.println("登录失败！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
