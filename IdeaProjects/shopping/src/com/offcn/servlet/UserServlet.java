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

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       //获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");

        //封装数据到实体对象中
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setSex(sex);
        user.setBirthday(DateUtil.stringToDate(birthday));

        //创建方法，执行注册对象
        UserService userService = new UserServiceImpl();
        boolean result = userService.registerUser(user);
        if(result){
            System.out.println("注册成功！");
            response.sendRedirect("/html/login.html");
        }else {
            System.out.println("注册失败！");
            response.sendRedirect("/html/register.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
