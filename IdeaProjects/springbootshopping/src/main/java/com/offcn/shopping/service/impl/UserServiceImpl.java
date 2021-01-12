package com.offcn.shopping.service.impl;

import com.offcn.shopping.bean.User;
import com.offcn.shopping.dao.UserDao;
import com.offcn.shopping.dao.impl.UserDaoImpl;
import com.offcn.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
@Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean registerUser(User user) {

        int result = userDao.insertUser(user);
        if(1 == result)
        {
            return true ;
        }
        return false;
    }

    @Override
    public User findUserByUserNameAndPassword(String username, String password) {
        return userDao.findUserByUserNameAndPassword(username , password);
    }
}
