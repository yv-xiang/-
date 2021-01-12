package com.offcn.servlet;


import com.offcn.bean.User;
import com.offcn.service.UserService;
import com.offcn.service.impl.UserServiceImpl;
import com.offcn.util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by 金喆
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.设置编码为 Utf-8
        request.setCharacterEncoding("utf-8");

        //2.接受数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        Date birthday = DateUtil.strToDate(request.getParameter("birthday"));

        //3.将接收到数据封装到javabean 便于传递给Service层
        User user= new User();
        user.setUsername(null);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        user.setBirthday(birthday);
        user.setSex(sex);

        //4.创建UserService对象 执行注册方法
        UserService userService = new UserServiceImpl();
        boolean result = userService.registerUser(user);

        if(result)
        {
            System.out.println("注册成功！");
            //重定向到login.html
            response.sendRedirect("/html/login.html");

        }else{
            System.out.println("注册失败！");
            //重新定向到 register.html
            response.sendRedirect("/html/register.html");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
