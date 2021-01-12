package com.offcn.dao;

import com.offcn.bean.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> findProduct(Integer pro_state);
    public Product findById(Integer id);
}
