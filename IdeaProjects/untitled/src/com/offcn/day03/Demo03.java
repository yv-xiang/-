package com.offcn.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo03 {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db1";
        String username = "root";
        String password = "root";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate("delete from account where id=3");
        System.out.println(result);

    }
}
