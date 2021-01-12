package com.offcn.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.bean.User;
import com.offcn.dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;


public class UserDaoImpl implements UserDao {
    private ComboPooledDataSource dataSource = new ComboPooledDataSource();

    @Override
    public int insertUser(User user) {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "insert into user(username,password,email,name,sex,birthday)values(?,?,?,?,?,?)";
        int result = 0;
        try {
            result = queryRunner.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getName(),user.getSex(), user.getBirthday());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public User findUserandPassword(String username,String password) {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "select userid,username,password,email,name,sex,birthday from user where username = ? and password = ?";
        User user = null;
        try {
            user = queryRunner.query(sql, new BeanHandler<>(User.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
