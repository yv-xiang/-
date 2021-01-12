package com.offcn.shopping.servlet;

import com.offcn.shopping.bean.Product;
import com.offcn.shopping.service.ProductService;
import com.offcn.shopping.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/ProductShowServlet")
public class ProductShowServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService productService = new ProductServiceImpl();
        //从业务层获取数据
        List<Product> hotList = productService.findAllProductByState(1);
        List<Product> optimizationList = productService.findAllProductByState(2);

        //把数据封装到request作用域中
        request.setAttribute("hotList" , hotList);
        request.setAttribute("optList" , optimizationList);

        //转发到商品展示页面
        request.getRequestDispatcher("/product_show.jsp").forward(request , response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request , response);
    }
}
