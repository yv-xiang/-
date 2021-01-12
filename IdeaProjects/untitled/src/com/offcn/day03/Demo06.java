package com.offcn.day03;

import java.sql.*;

public class Demo06 {
    public static void main(String[] args)  {
    String driver = "com.mysql.jdbc.Driver";
    String url ="jdbc:mysql://localhost:3306/db1";
    String username = "root";
    String password= "root";
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(driver);
             connection = DriverManager.getConnection(url, username, password);
             statement = connection.createStatement();
             connection.setAutoCommit(false);
             String sql ="update  account set balance= balance-500 where id=1";
             statement.executeUpdate(sql);

             sql = "update  account set balance = balance +500 where id=2";
             statement.executeUpdate(sql);
             connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {

            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }



    }
}
