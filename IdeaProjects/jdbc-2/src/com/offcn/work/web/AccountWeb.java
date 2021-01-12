package com.offcn.work.web;

import com.offcn.work.bean.Account;
import com.offcn.work.service.AccountService;
import com.offcn.work.service.impl.AccountServiceImpl;

import java.sql.SQLException;

public class AccountWeb {
    public static void main(String[] args) throws SQLException {
        AccountService accountService = new AccountServiceImpl();

            accountService.MoneyTransfer(500,1,2);
        Account balanceById = accountService.getBalanceById(1);
        Account balanceById1 = accountService.getBalanceById(2);

        System.out.println("张三的账户余额为："+balanceById);
        System.out.println("李思的账户余额为："+balanceById1);
    }
}
