package com.offcn.shopping.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.shopping.bean.User;
import com.offcn.shopping.dao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

   private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertUser(User user) {


        String sql = "insert into user (username , password , sex , name , email ,birthday ) values" +
                " (?,?,?,?,?,?)";

        int result = 0 ;
        result = jdbcTemplate.update(sql , user.getUsername() , user.getPassword() , user.getSex() , user.getName() , user.getEmail() , user.getBirthday());
        System.out.println("这个代码执行。。。。。。");
        return result;
    }

    @Override
    public User findUserByUserNameAndPassword(String username, String password) {


        String sql = "select userid, username , password , sex , name , email , birthday from user where username = ? and password = ?";
        return  jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setSex(resultSet.getString("sex"));
                user.setEmail(resultSet.getString("email"));
                return user;
            }
        },username,password);

    }
}
