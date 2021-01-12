package com.offcn.work.dao;

import com.offcn.work.bean.Account;

import java.sql.Connection;
import java.sql.SQLException;

public interface AccountDao {
    //根据id减钱
    public void subMoneyTransfer(Connection connection, double money, int id) throws SQLException;
    //根据id加钱
    public void addMoneyTransfer(Connection connection,double money,int id) throws SQLException;
    //根据id查询余额
    public Account getBalanceById(int id) throws SQLException;
}
