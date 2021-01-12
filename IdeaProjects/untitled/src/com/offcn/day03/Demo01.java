package com.offcn.day03;

import java.sql.Connection;
import java.sql.DriverManager;

public class Demo01 {
    public static void main(String[] args) throws Exception {


        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
        System.out.println(conn);
    }


}
