package com.offcn.day04;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Demo04 {
    public static void main(String[] args) {

    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    QueryRunner queryRunner = new QueryRunner(dataSource);

    String sql = "select id ,name ,age ,score from student";
        try {
            List<Student> query = queryRunner.query(sql, new BeanListHandler<>(Student.class));
            for(Student student:query){
                System.out.println(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
