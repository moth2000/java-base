package org.day8;

public class Account {
    //定义成员
    public String accountId;   //账户ID
    public String userName;    //用户姓名
    public String password;    //密码
    public double balance = 0; //账号余额(初始为0)
    StringBuilder TransactionList = new StringBuilder(); //交易记录(拼接字符串)
}
