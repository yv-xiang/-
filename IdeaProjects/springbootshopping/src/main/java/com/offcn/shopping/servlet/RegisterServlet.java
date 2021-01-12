package com.offcn.shopping.servlet;

import com.offcn.shopping.bean.User;
import com.offcn.shopping.service.UserService;
import com.offcn.shopping.service.impl.UserServiceImpl;
import com.offcn.shopping.util.DateUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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

        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        //2.接受数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        Date birthday = DateUtil.strToDate(request.getParameter("birthday"));

        //3.将接收到数据封装到javabean 便于传递给Service层
        User user= new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        user.setBirthday(birthday);
        user.setSex(sex);

        //4.创建UserService对象 执行注册方法
        UserService userService =context.getBean("userService",UserService.class);
        //UserService userService = new UserServiceImpl();
        boolean result = userService.registerUser(user);

        if(result)
        {
            System.out.println("注册成功！");
            //重定向到login.html
            response.sendRedirect("/login.jsp");

        }else{
            System.out.println("注册失败！");
            //重新定向到 register.html
            response.sendRedirect("/register.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
