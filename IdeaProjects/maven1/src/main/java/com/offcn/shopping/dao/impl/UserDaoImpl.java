package com.offcn.shopping.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.shopping.bean.User;
import com.offcn.shopping.dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private ComboPooledDataSource dataSource = new ComboPooledDataSource();

    @Override
    public int insertUser(User user) {

        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "insert into user (username , password , sex , name , email ,birthday ) values" +
                " (?,?,?,?,?,?)";

        int result = 0 ;
        try {
            result = queryRunner.update(sql , user.getUsername() , user.getPassword() , user.getSex() , user.getName() , user.getEmail() , user.getBirthday());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("这个代码执行。。。。。。");
        return result;
    }

    @Override
    public User findUserByUserNameAndPassword(String username, String password) {

        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "select userid, username , password , sex , name , email , birthday from user where username = ? and password = ?";

        User user = null ;
        try {
            user =  queryRunner.query(sql ,new BeanHandler<>(User.class) , username , password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
