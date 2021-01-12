package com.offcn.service.impl;


import com.offcn.bean.User;
import com.offcn.dao.UserDao;
import com.offcn.dao.impl.UserDaoImpl;
import com.offcn.service.UserService;

/**
 * Created by 金喆
 */

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean registerUser(User user) {

        int result = userDao.insertUser(user);
        if(1 == result)
        {
            return true ;
        }
        return false;
    }
}
