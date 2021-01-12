package com.offcn.work.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.work.bean.Account;
import com.offcn.work.dao.AccountDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {

    //减钱
    @Override
    public void subMoneyTransfer(Connection connection, double money, int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update account set balance = balance - ? where id = ?";
        queryRunner.update(connection,sql,money,id);
    }
    //加钱
    @Override
    public void addMoneyTransfer(Connection connection, double money, int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update account set balance = balance + ? where id = ?";
        queryRunner.update(connection,sql,money,id);
    }

    @Override
    public Account getBalanceById(int id) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);

        String sql = "select id , name, balance from account where id = ?";
        Account account = queryRunner.query(sql, new BeanHandler<>(Account.class),id);
        return account;

    }
}
