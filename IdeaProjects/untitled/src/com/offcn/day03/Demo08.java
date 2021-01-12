package com.offcn.day03;

import com.offcn.util.Jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo08 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();

        Connection connection = Jdbc.getConnection();
        Statement statement = connection.createStatement();

        String sql ="select name, password from user where name='admin' and password='123'";
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()){
            System.out.println("欢迎您 "+username);
        }else {
            System.out.println("请输入正确的用户名和密码！");
        }
    }
}
