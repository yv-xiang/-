package com.offcn.day04;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class Demo03 {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);

        String sql = "select id,name,age,score from student where id = ?";
        Student query = queryRunner.query(sql, new BeanHandler<>(Student.class),4);
        System.out.println(query);
    }
}
