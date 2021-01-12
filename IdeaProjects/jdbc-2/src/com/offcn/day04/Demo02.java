package com.offcn.day04;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo02 {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        /*String sql = "insert into student(name,age,score)value(?,?,?)";
        int update = queryRunner.update(connection,sql,"赵敏",23,97.1);*/

        /*String sql = "update student set name = ?,age = ?,score = ? where id =?";
        queryRunner.update(connection,sql,"张珊",24,86.5,5);*/

        /*String sql = "update student set name = ? , age = ? , score = ? where id = ?";
        queryRunner.update(connection , sql , "周芷若" ,19 , 77.5 ,4);*/

        String sql = "delete from student where id = ?";
        queryRunner.update(connection , sql , 6);
        dataSource.close();

    }
}
