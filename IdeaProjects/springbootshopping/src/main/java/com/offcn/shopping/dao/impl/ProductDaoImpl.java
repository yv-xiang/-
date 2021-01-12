package com.offcn.shopping.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.shopping.bean.Product;
import com.offcn.shopping.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
@Autowired
  private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> findProductListByState(Integer state) {


        List<Product> productList = null ;

        String sql = "select pro_id proId , pro_name proName , pro_num proNum , " +
                " market_price marketPrice , shop_price shopPrice , pro_color proColor, " +
                " pro_total_count proTotalCount , pro_min_img proMinImg , pro_state proState " +
                " from product " +
                " where pro_state = ?";


            productList =  jdbcTemplate.query(sql, new RowMapper<Product>() {
                @Override
                public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                    Product product = new Product();
                    product.setMarketPrice(resultSet.getDouble("marketPrice"));
                    product.setProColor(resultSet.getString("proColor"));
                    product.setProId(resultSet.getInt("proId"));
                    product.setProMinImg(resultSet.getString("proMinImg"));
                    product.setProName(resultSet.getString("proName"));
                    product.setProNum(resultSet.getString("proNum"));
                    product.setProState(resultSet.getInt("proState"));
                    product.setProTotalCount(resultSet.getInt("proTotalCount"));
                    product.setShopPrice(resultSet.getDouble("shopPrice"));
                    return product;
                }
            }, state);


        return productList;
    }

    @Override
    public Product findProductById(Integer id) {

        String sql = "select pro_id proId , pro_name proName , pro_num proNum , " +
                " market_price marketPrice , shop_price shopPrice , pro_color proColor, " +
                " pro_total_count proTotalCount , pro_min_img proMinImg , pro_state proState " +
                " from product " +
                " where pro_id = ?";

        return jdbcTemplate.queryForObject(sql ,new RowMapper<Product>(){
               @Override
               public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                   Product product = new Product();
                   product.setMarketPrice(resultSet.getDouble("marketPrice"));
                   product.setProColor(resultSet.getString("proColor"));
                   product.setProId(resultSet.getInt("proId"));

                   product.setProMinImg(resultSet.getString("proMinImg"));
                   product.setProName(resultSet.getString("proName"));
                   product.setProNum(resultSet.getString("proNum"));
                   product.setProState(resultSet.getInt("proState"));
                   product.setProTotalCount(resultSet.getInt("proTotalCount"));
                   product.setShopPrice(resultSet.getDouble("shopPrice"));
                   return product;
               }
           },id);



    }
}
