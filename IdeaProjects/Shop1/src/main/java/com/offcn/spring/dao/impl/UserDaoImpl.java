package com.offcn.spring.dao.impl;

import com.offcn.spring.bean.User;
import com.offcn.spring.dao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into user (username , password , sex , name , email ,birthday ) values" +
                " (?,?,?,?,?,?)";

        int result = jdbcTemplate.update(sql, user.getUsername(), user.getPassword(),
                user.getSex(), user.getName(), user.getEmail(), user.getBirthday());
        return result;
    }

    @Override
    public int deleteUserById(Integer id) {
        String sql = "delete from user where userId = ?";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }

    @Override
    public int updateUse(User user) {
        String sql= "update user set username = ? where userId =?";
        int update = jdbcTemplate.update(sql, user.getUsername(), user.getUserId());
        return update;
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where userId = ?";
        User user = new User();
        jdbcTemplate.query(sql,new Object[]{id}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("Username"));
                user.setPassword(resultSet.getString("password"));
            }
        });
        return user;
    }

    @Override
    public User findUserById2(int id) {
        String sql = "select * from user where userId = ?";
        return  jdbcTemplate.queryForObject(sql,new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        },id);

    }

    @Override
    public List<User> findAll() {
        String sql = "select * from user";

        return jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {

                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        });
    }

    @Override
    public List<User> findByName(String name) {
        String sql = "select*from user where username like ?";

        return jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setPassword(resultSet.getString("password"));
                user.setUsername(resultSet.getString("username"));
                user.setUserId(resultSet.getInt("userId"));
                return user;
            }
        },"%"+name+"%");
    }


}
