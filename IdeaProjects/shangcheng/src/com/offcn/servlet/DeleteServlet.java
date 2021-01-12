package com.offcn.servlet;

import com.offcn.bean.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("pro_id");
        Map<Product,Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
        Product product = null;
        if (cart != null){
            Set<Product> products = cart.keySet();
            for (Product prod : products){
                if (prod.getPro_id() == Integer.parseInt(id)){
                    product = prod;
                    break;
                }
            }
            cart.remove(product);
            double sum = 0 ;
            Set<Product> productSet =  cart.keySet();
            for(Product pro : productSet)
            {
                Integer num = cart.get(pro);
                sum = sum + pro.getShop_price() * num;
            }
            HttpSession session = request.getSession();
            session.setAttribute("totalPrice" , sum);

            response.sendRedirect("jsp/cart.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
