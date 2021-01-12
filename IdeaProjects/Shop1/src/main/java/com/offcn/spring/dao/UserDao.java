package com.offcn.spring.dao;

import com.offcn.spring.bean.User;

import java.util.List;

public interface UserDao {
    public int insertUser(User user);
    public int deleteUserById(Integer id);
    public int updateUse(User user);
    public User findUserById(int id);
    public User findUserById2(int id);
    public List<User> findAll();
    public List<User> findByName(String name);
}
