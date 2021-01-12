package com.offcn.day03;

import com.offcn.util.Jdbc;

import java.sql.*;
import java.util.Scanner;

public class Demo09 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();

        //导入驱动
        Connection connection = Jdbc.getConnection();
        //Statement statement = connection.createStatement();

        //查询语句
        String sql ="select name,password from user where name = ? and password = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);

        //结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            System.out.println("欢迎您："+username);
        }else {
            System.out.println("请输入正确的用户名或密码！");
        }

    }
}
