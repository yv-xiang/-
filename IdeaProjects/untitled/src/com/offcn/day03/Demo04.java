package com.offcn.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo04 {
    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db1";
        String username = "root";
        String password = "root";
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate("update account set balace=500 where id=2");
            System.out.println(result);

            connection.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
