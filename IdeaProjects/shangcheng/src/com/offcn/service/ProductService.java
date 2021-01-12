package com.offcn.service;

import com.offcn.bean.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findProduct(Integer pro_state);
    public Product findById(Integer id);
}
