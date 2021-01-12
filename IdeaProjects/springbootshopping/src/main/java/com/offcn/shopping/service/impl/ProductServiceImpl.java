package com.offcn.shopping.service.impl;

import com.offcn.shopping.bean.Product;
import com.offcn.shopping.dao.ProductDao;
import com.offcn.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("/ProductService")
public class ProductServiceImpl implements ProductService {
@Autowired
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
