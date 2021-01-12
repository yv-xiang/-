package com.offcn.service.impl;

import com.offcn.bean.Product;
import com.offcn.dao.ProductDao;
import com.offcn.dao.impl.ProductDaoImpl;
import com.offcn.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoImpl();
    @Override
    public List<Product> findProduct(Integer pro_state) {


        return productDao.findProduct(pro_state);
    }

    @Override
    public Product findById(Integer id) {
        return productDao.findById(id);
    }

}
