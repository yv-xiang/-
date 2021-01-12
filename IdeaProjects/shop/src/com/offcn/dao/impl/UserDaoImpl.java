package com.offcn.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.bean.User;
import com.offcn.dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * Created by 金喆
 */

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
}
