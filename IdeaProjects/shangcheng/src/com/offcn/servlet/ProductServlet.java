package com.offcn.servlet;

import com.offcn.bean.Product;
import com.offcn.service.ProductService;
import com.offcn.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        List<Product> hotList = productService.findProduct(1);
        List<Product> optList = productService.findProduct(2);
        request.setAttribute("hotlist",hotList);
        request.setAttribute("optlist",optList);
        request.getRequestDispatcher("jsp/Product.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
