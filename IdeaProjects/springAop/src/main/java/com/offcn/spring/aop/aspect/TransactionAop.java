package com.offcn.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class TransactionAop {
    public void createTransaction(JoinPoint joinPoint)
    {
        Object[] joinPointArgs = joinPoint.getArgs();
        System.out.println(joinPointArgs[0]);
        System.out.println(joinPointArgs[1]);
        System.out.println("打开事务！");
        String name = joinPoint.getSignature().getName();
        System.out.println(name);
    }

    public void commitTransaction()
    {
        System.out.println("提交事务！");
    }

    public void rollbackTransaction()
    {
        System.out.println("回滚事务！");
    }

    public void closeTransaction()
    {
        System.out.println("关闭事务！");
    }

    public void arroundTransaction(ProceedingJoinPoint proceedingJoinPoint){

        try {
            System.out.println("打开事务！");
            proceedingJoinPoint.proceed();
            System.out.println("提交事务！");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("回滚事务！");
        }
        System.out.println("关闭事务！");

    }
}
