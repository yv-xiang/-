package com.offcn.shopping.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class SecondFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("经过第二个filter。。");
        chain.doFilter(req, resp);
        System.out.println("离开第二个filter。。");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
