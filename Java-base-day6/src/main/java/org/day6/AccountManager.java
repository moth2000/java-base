package org.day6;

import java.util.Random;

public class AccountManager {
    //定义成员
    public static Account[] accounts = new Account[100]; //定义100个存储账号的数组
    public static int currentAccountIndex = 0;           //账号索引
    public static Account currentAccount = null;

    //开设账户:判断密码是否一致,若一致则存入账户数组accounts
    public static Account openAccount(String username, String password, String checkpassword){
        //若密码不一致
        if(!password.equals(checkpassword)){             //字符串的不相等不能用!=
            System.out.println("两次输入的密码不一致");
            return null;
        }
        //若密码一致
        Account account = new Account();
        account.userName = username;
        account.password = password;
        account.accountId = getRandomAccountId();
        accounts[currentAccountIndex] = account;   //账号存入数组
        currentAccountIndex ++;
        return account;
    }

    //定义随机生产6位数账户ID的方法
    private static String getRandomAccountId(){
        Random random = new Random();             //定义随机对象
        StringBuilder sb = new StringBuilder();   //定义字符拼接对象
        for (int i = 0;i < 6;i++){
            int num = random.nextInt(10);
            sb.append(num);
        }
        return sb.toString();                    //返回对象的字符串类型
    }

    //登录账号:若账号存在且密码正确返回true，否则返回false
    public static boolean loginAccount(String accountID, String password){
        for (int i = 0; i < currentAccountIndex; i++){
            Account account = accounts[i];
            if (account == null){
                continue;
            }
            if (account.accountId.equals(accountID) && account.password.equals(password)){
                currentAccount = account;
                return true;
            }
        }
        return false;
    }

    //存钱方法
    public static void deposit(double amount){
        if (amount <= 0){
            System.out.println("存款失败! 存款金额必须大于0");
        }else{
            currentAccount.balance += amount;
            currentAccount.TransactionList.append("存款: " + amount + " 元，剩余金额为: " + currentAccount.balance +  " 元\n");  //记录存款信息
            System.out.println("存款成功！您当前的余额为: " + currentAccount.balance+ " 元");
        }
    }

    //提现方法
    public static void withdraw(double amount){
        if (amount <= 0){
            System.out.println("提现失败! 提现金额必须大于0");
        }else if(amount > currentAccount.balance){
            System.out.println("余额不足! 提现金额大于您的余额: " + currentAccount.balance + " 元");
        }else {
            currentAccount.balance -= amount;
            currentAccount.TransactionList.append("提现: " + amount + " 元，剩余金额为: " + currentAccount.balance +  " 元\n");  //记录提现信息
            System.out.println("提现成功！您当前的余额为: " + currentAccount.balance + " 元" );
        }
    }

    //查询余额方法
    public static void getBalance(){
        System.out.println("您当前的余额为: " + currentAccount.balance+ " 元");
    }

    //查询转账账户是否存在
    private static Account getAccountByIdAndUsername(String accountId, String username) {
        for (int i = 0; i < currentAccountIndex; i++) {
            Account account = accounts[i];
            if(account == null) {
                continue;
            }
            if (account.accountId.equals(accountId) && account.userName.equals(username)) {
                return account;        //获得账号信息
            }
        }
        return null;
    }

    //转账方法
    public static void transfer(String toAccountId, String toUser,double amount){
        Account toAccount = getAccountByIdAndUsername(toAccountId,toUser);
            if (toAccount == null){
                System.out.println("该账号不存在!");
            } else if (amount <= 0) {
                System.out.println("转账失败! 转账金额应大于0!");
            }else if (amount >= currentAccount.balance){
                System.out.println("余额不足! 您当前余额为: " + currentAccount.balance +" 元");
            }else {
                currentAccount.balance -= amount;
                toAccount.balance +=amount;
                currentAccount.TransactionList.append("向账号 "+ toAccountId + " 转账: " + amount + " 元，剩余金额为: " + currentAccount.balance +  " 元\n");  //记录转帐信息
                toAccount.TransactionList.append("收到账号 "+ currentAccount.accountId + " 的转账: " + amount + " 元，剩余金额为: " + toAccount.balance +  " 元\n");  //记录转帐信息
                System.out.println("转账成功! 您当前余额为: " + currentAccount.balance +" 元");
            }
    }

    //打印交易信息
    public static void printTransactionList(){
        System.out.println(currentAccount.TransactionList);
    }
}
