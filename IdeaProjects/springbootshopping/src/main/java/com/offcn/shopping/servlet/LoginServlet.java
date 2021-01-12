package com.offcn.shopping.servlet;

import com.offcn.shopping.bean.User;
import com.offcn.shopping.service.UserService;
import com.offcn.shopping.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Autowired
    private UserService userService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码
        request.setCharacterEncoding("utf-8");

        //2.接收数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //由于参数过少，没有必要封装对象


        //3.调用业务层方法。

//        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
//        UserService userService = context.getBean("userService",UserService.class);

          User user = userService.findUserByUserNameAndPassword(username, password);

        if(null == user)
        {//登陆错误跳回到登陆页面
            //登录失败时重定向到login.jsp,本质是像login.jsp发送请求
            response.sendRedirect("/login.jsp?message=loginerror");

        }else{
            //正确的跳转到 商品页面

            //获取Session对象 ，并把上面查询到的user对象放入到session中
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            response.sendRedirect("/ProductShowServlet");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
