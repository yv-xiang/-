package com.offcn.shopping.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/HttpSessionServlet")
public class HttpSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request ,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //创建Session
        HttpSession session = request.getSession();

        String sessionId = session.getId();
//        System.out.println(sessionId);

        request.setAttribute("requestName" , "赵敏");
        session.setAttribute("sessionName" ,"张三丰");
        //服务器端转发
//        request.getRequestDispatcher("/jsp/session.jsp").forward(request,response);
        //重定向
        response.sendRedirect("/jsp/session.jsp");
    }
}
