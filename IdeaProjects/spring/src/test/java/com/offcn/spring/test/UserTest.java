package com.offcn.spring.test;


import com.offcn.spring.User;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    
 @Test
    public void userNoSpring(){
        User user = new User();
        System.out.println(user);
    }
    @Test
    public void userSpring(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        User user = context.getBean("user",User.class);
        System.out.println(user);
    }
    @Test
    public void userSpring1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        User user = context.getBean("user1",User.class);
        System.out.println(user);
    }
    @Test
    public void userSpring2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        User user = context.getBean("user2",User.class);
        System.out.println(user);
    }
}
