package com.offcn.servlet;

import com.offcn.bean.Product;
import com.offcn.service.ProductService;
import com.offcn.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("pro_id"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));

        ProductService productService = new ProductServiceImpl();
        Product product = productService.findById(id);

        HttpSession session = request.getSession();
        Map<Product, Integer> cart = (Map<Product,Integer>)session.getAttribute("cart");

        if(null == cart)//表示购物车中没有cart 也就是说第一次购物  需要创建购物车
        {
            cart = new HashMap<>();
            cart.put(product,quantity);

            session.setAttribute("cart" ,cart);
        }
        else {
            //直接将商品放入购物车中即可

            // 判断购物车中是否包含正在操作的这个商品
            Set<Product> set = cart.keySet();
            boolean flag = false ;
            Product pro = null ;
            for(Product p : set)
            {
                if(product.getPro_id() == p.getPro_id())
                {
                    flag = true ;
                    pro = p;
                    break;
                }
            }
            if(flag)//说明购物车中有相同的商品 直接累积数量就可以了
            {
                Integer num = cart.get(pro);
                cart.put(pro , num + quantity);

            }
            else{
                //说明购物车中没有相同的商品 直接放入即可
                cart.put(product,quantity);
            }

        }
        double sum = 0 ;
        Set<Product> productSet =  cart.keySet();
        for(Product pro : productSet)
        {
            Integer num = cart.get(pro);
            sum = sum + pro.getShop_price() * num;
        }
        request.setAttribute("totalPrice" , sum);

        request.getRequestDispatcher("jsp/cart.jsp").forward(request,response);
    }
}
