package com.offcn.shopping.dao;

import com.offcn.shopping.bean.Product;

import java.util.List;

public interface ProductDao {

    public List<Product> findProductListByState(Integer state);

    public Product findProductById(Integer id);
}
