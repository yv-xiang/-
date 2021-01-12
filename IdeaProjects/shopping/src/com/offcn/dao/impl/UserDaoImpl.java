package com.offcn.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.bean.User;
import com.offcn.dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    @Override
    public int insertUser(User user) {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "insert into user(username,password,email,name,sex,birthday)values(?,?,?,?,?,?) ";
      int result = 0;
        try {
             result = queryRunner.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getName(), user.getSex()
                    , user.getBirthday());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
