package com.offcn.maven;

public class HelloTest {

    public void testHello(){
        Hello hello = new Hello();
        String results = hello.sayHello("World");
        System.out.println("Hello Maven World".equals(results));
    }
}
