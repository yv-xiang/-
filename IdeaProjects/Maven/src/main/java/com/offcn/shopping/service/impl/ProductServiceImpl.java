package com.offcn.shopping.service.impl;

import com.offcn.shopping.bean.Product;
import com.offcn.shopping.dao.ProductDao;
import com.offcn.shopping.service.ProductService;

import java.util.List;


public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> findAllProductByState(Integer state) {
        return productDao.findProductListByState(state);
    }

    @Override
    public Product findProductById(Integer id) {
        return productDao.findProductById(id);
    }
}
