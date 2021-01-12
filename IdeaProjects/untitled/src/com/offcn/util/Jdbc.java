package com.offcn.util;

import java.sql.*;

public class Jdbc {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL ="jdbc:mysql://localhost:3306/db1";
    private static final String USERNAME = "root";
    private static final String PASSWORD ="root";
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void relase(Statement statement,Connection connection){
        relase(statement, connection);
    }
    public static void release(ResultSet resultSet, Statement statement,Connection connection){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement!=null){
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
