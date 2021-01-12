package com.offcn.spring.aop.service.impl;

import com.offcn.spring.aop.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void serviceUser(String name, String passwor) {
        System.out.println("dadadasaedd....weeewe");
    }

    @Override
    public void deleteUser(Integer id) {
        System.out.println("iushcuinsdiksdi");

    }
}
