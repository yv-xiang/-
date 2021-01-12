package com.offcn.spring;

import com.offcn.spring.bean.User;
import com.offcn.spring.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;


@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class lUserTest {
@Autowired
private UserDao userDao;
@Test
    public void testQ(){

        User user = new User();
        user.setName("李思");
        user.setUsername("天鹰教");
        user.setSex("女");
        user.setPassword("123123");
        user.setEmail("123@139.com");
        user.setBirthday(new Date());
    int i = userDao.insertUser(user);
    System.out.println(i);
    System.out.println(user);

    }
    @Test
    public void deleteUser(){
        int i = userDao.deleteUserById(6);
        System.out.println(i);
    }
    @Test
    public void updateUser(){
    User user = new User();
    user.setUsername("妖姬");
    user.setUserId(7);
        int i = userDao.updateUse(user);
        System.out.println(i);
        System.out.println(user);
    }
    public void seleUser(){

        User userById = userDao.findUserById(7);
        System.out.println(userById);
    }
    @Test
    public void findUser(){

        User byId = userDao.findUserById(7);
        System.out.println(byId);
    }
    @Test
    public void find2User(){
        User userById2 = userDao.findUserById2(7);
        System.out.println(userById2);
}
@Test
    public void find(){
        List<User> all = userDao.findAll();
        System.out.println(all);
    }
    @Test
    public void likeUser(){
        List<User> byName = userDao.findByName("阿");
        System.out.println(byName);
    }

}
