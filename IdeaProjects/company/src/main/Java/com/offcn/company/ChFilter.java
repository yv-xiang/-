package com.offcn.company;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(urlPatterns = "/*")
public class ChFilter implements Filter {

    @Override
    public void doFilter(ServletRequest Request, ServletResponse Response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)Request;
        HttpServletResponse response =(HttpServletResponse)Response;
        Request.setCharacterEncoding("utf8");
        Response.setCharacterEncoding("utf8");
        filterChain.doFilter(Request,Response);
    }


}
