package com.offcn.servlet;

import com.offcn.bean.User;
import com.offcn.service.UserService;
import com.offcn.service.impl.UserServiceImpl;
import com.offcn.servlet.util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        Date birthday = DateUtil.stringToDate( request.getParameter("birthday"));

        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);
        user.setSex(sex);
        user.setBirthday(birthday);

        UserService userService = new UserServiceImpl();
        boolean result = userService.registerUser(user);
        if (result){
            System.out.println("注册成功！");
            response.sendRedirect("/jsp/login.jsp");
        }else {
            System.out.println("注册失败！");
            response.sendRedirect("/jsp/register.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
