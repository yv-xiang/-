package com.offcn.spring.test;

import com.offcn.spring.Beanzhu;
import com.offcn.spring.Car;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:ApplicationContext.xml"})
public class BeanzhuText {
    @Autowired
    private Beanzhu beanzhu;
    @Autowired
    private Car car;
    @Test
    public void  useSpring(){
       // ApplicationContext context = new  ClassPathXmlApplicationContext("ApplicationContext.xml");
        //Beanzhu bean = context.getBean("bean1",Beanzhu.class);
        //System.out.println(bean.toString());
        System.out.println(beanzhu);
        System.out.println(car);
    }

}
