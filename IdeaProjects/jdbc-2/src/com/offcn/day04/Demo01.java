package com.offcn.day04;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo01 {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource comb = new ComboPooledDataSource();
        Connection conn = comb.getConnection();
        String sql = "insert into student(name,age,score) values (?,?,?)";
        PreparedStatement psa = conn.prepareStatement(sql);
        psa.setString(1,"张三");
        psa.setInt(2,23);
        psa.setDouble(3,94.3);
        int i = psa.executeUpdate();
        System.out.println("受影响行数："+i);
        psa.close();
        conn.close();

    }

}
