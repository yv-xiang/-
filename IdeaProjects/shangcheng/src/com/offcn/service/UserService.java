package com.offcn.service;

import com.offcn.bean.User;

public interface UserService {
    public boolean registerUser(User user);

    public User findUserandpassword(String username ,String password);

}
