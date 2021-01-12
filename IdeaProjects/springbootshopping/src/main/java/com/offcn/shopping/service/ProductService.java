package com.offcn.shopping.service;

import com.offcn.shopping.bean.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAllProductByState(Integer state);

    public Product findProductById(Integer id) ;

}
