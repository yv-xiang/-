package com.offcn.work.service.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.work.bean.Account;
import com.offcn.work.dao.AccountDao;
import com.offcn.work.dao.impl.AccountDaoImpl;
import com.offcn.work.service.AccountService;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {

    AccountDao accountDao =new AccountDaoImpl();

    @Override
    public void MoneyTransfer(double money, int srcId, int destId)  {

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Connection connection = null;

        try {
            connection = comboPooledDataSource.getConnection();
            connection.setAutoCommit(false);

            accountDao.addMoneyTransfer(connection,money,destId);
//            Integer.parseInt("abc");
            accountDao.subMoneyTransfer(connection,money,srcId);

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    //输入的id
    @Override
    public Account getBalanceById(Integer id) throws SQLException {

        return accountDao.getBalanceById(id);
    }
}
