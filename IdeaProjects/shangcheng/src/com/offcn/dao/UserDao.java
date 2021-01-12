package com.offcn.dao;

import com.offcn.bean.User;

public interface UserDao {
    public int insertUser(User user);
    public User findUserandPassword(String username,String password);
}
