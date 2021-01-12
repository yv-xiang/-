package com.offcn.day04;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.SQLException;

public class Demo05 {
    public static void main(String[] args) {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);

        String sql = "select count(*) from student";

        try {
            Object query = queryRunner.query(sql, new ScalarHandler());
            long l =(long)query;
            System.out.println(l);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
