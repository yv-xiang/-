package com.offcn.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.bean.Product;
import com.offcn.dao.ProductDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private ComboPooledDataSource dataSource = new ComboPooledDataSource();
    @Override
    public List<Product> findProduct(Integer pro_state) {
        QueryRunner queryRunner = new QueryRunner(dataSource);

        String sql = "select pro_id,pro_name,pro_num,market_price,shop_price,pro_color,pro_total_count," +

                "pro_max_img,pro_min_img,pro_state from product where pro_state = ?";
        List<Product> productList = null;
        try {
             productList = queryRunner.query(sql, new BeanListHandler<>(Product.class), pro_state);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product findById(Integer id) {
        QueryRunner queryRunner = new QueryRunner(dataSource);

        String sql = "select pro_id,pro_name,pro_num,market_price,shop_price,pro_color,pro_total_count," +

                "pro_max_img,pro_min_img,pro_state from product where pro_id = ?";
        Product product = null;
        try {
             product = queryRunner.query(sql, new BeanHandler<>(Product.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
