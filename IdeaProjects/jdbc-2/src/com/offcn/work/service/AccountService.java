package com.offcn.work.service;

import com.offcn.work.bean.Account;

import java.sql.SQLException;

public interface AccountService {
    //转钱,srcid转钱,dest收钱
    public void MoneyTransfer(double money,int srcId,int destId) throws SQLException;
    //根据id,查询余额
    public Account getBalanceById(Integer id) throws SQLException;

}
