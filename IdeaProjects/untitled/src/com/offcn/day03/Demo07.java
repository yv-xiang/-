package com.offcn.day03;

import com.offcn.util.Jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo07 {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        try {
            connection = Jdbc.getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            String sql = "update account set balance = balance -500 where id = 1";
            statement.executeUpdate(sql);

            sql ="update account set balance =balance +500 where id = 2";
            statement.executeUpdate(sql);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally {
                Jdbc.relase(statement,connection);
            }
        }
    }
}
