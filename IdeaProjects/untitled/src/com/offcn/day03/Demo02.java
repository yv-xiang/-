package com.offcn.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo02 {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/db1";
        String username = "root";
        String password = "root";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, username, password);
        Statement statement =con.createStatement();
        String sql="INSERT INTO account (id,NAME,balance)VALUES(4,'大家啊',4000)" ;
        int result;
        result = statement.executeUpdate(sql);
        System.out.println(result);
        statement.close();
        con.close();
    }
}
