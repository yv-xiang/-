package com.offcn.shopping.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.shopping.bean.Product;
import com.offcn.shopping.dao.ProductDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;


public class ProductDaoImpl implements ProductDao {

    private ComboPooledDataSource dataSource = new ComboPooledDataSource();

    @Override
    public List<Product> findProductListByState(Integer state) {

        QueryRunner queryRunner = new QueryRunner(dataSource);
        List<Product> productList = null ;

        String sql = "select pro_id proId , pro_name proName , pro_num proNum , " +
                " market_price marketPrice , shop_price shopPrice , pro_color proColor, " +
                " pro_total_count proTotalCount , pro_min_img proMinImg , pro_state proState " +
                " from product " +
                " where pro_state = ?";

        try {
            productList =  queryRunner.query(sql , new BeanListHandler<>(Product.class) ,state);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public Product findProductById(Integer id) {

        String sql = "select pro_id proId , pro_name proName , pro_num proNum , " +
                " market_price marketPrice , shop_price shopPrice , pro_color proColor, " +
                " pro_total_count proTotalCount , pro_min_img proMinImg , pro_state proState " +
                " from product " +
                " where pro_id = ?";

        QueryRunner queryRunner = new QueryRunner(dataSource);

        Product product = null ;
        try {
           product =  queryRunner.query(sql , new BeanHandler<>(Product.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }
}
