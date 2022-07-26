package org.day6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        printWelcome();
        printMainMenu();
    }

    //定义打印欢迎的方法
    public static void printWelcome(){
        System.out.println("=== welcome to the ATM System ===");
    }

    //定义主菜单页面的方法
    public static void printMainMenu(){
        System.out.println("=== 主菜单 ===");
        System.out.println("1.开设账户");
        System.out.println("2.登陆账户");
        System.out.println("3.退出");
        System.out.println("=== 请输入相应数字进行操作 ===");
        //获取用户输入
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        //根据用户输入进入相应选项
        switch(choice){
            case 1:
                System.out.println("=== 开设账号 ===");
                //获取开设账号信息
                System.out.println("请输入姓名: ");
                String userName = in.next();
                System.out.println("请输入密码: ");
                String password = in.next();
                System.out.println("再输入一次密码: ");
                String checkPassword = in.next();

                //检验开设账号信息
                Account result = AccountManager.openAccount(userName, password, checkPassword);
                if (result != null){
                    System.out.println("开户成功！");
                    System.out.println("你的账号为: " + result.accountId);
                }else {
                    System.out.println("开户失败!");
                }
                printMainMenu();
                break;

            case 2:
                System.out.println("=== 登录账户 ===");
                //获取登录账号信息
                System.out.println("请输入账户: ");
                String accountId = in.next();
                System.out.println("请输入密码: ");
                String pwd = in.next();

                //检验账户和密码是否正确或存在
                boolean isLogin = AccountManager.loginAccount(accountId,pwd);
                if (isLogin){
                    System.out.println("登录成功!");
                    printUserMenu();
                }else{
                    System.out.println("登录失败!");
                    printMainMenu();
                }
                break;

            case 3:
                System.out.println("=== 退出 ====");
                break;

            default:
                System.out.println("输入错误!请输入相应操作对应的数字。");
                printMainMenu();
            }
        }

    //定义用户菜单的方法
    public static void printUserMenu(){
        System.out.println("=== 用户菜单 ===");
        System.out.println("1.提现");
        System.out.println("2.存钱");
        System.out.println("3.转账");
        System.out.println("4.查询余额");
        System.out.println("5.查询交易记录");
        System.out.println("6.退出登录");
        System.out.println("=== 请输入相应数字进行操作 ===");
        //获取用户输入
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        //根据用户输入进入相应选项
        switch (choice){
            case 1:
                System.out.println("=== 提现 ===");
                //获取提现金额
                System.out.println("请输入提现金额: ");

                //进行提现操作
                double amount = in.nextDouble();
                AccountManager.withdraw(amount);
                printUserMenu();
                break;

            case 2:
                System.out.println("=== 存钱 ===");
                //获取存钱金额
                System.out.println("请输入存钱金额: ");

                //进行存钱操作
                amount = in.nextDouble();
                AccountManager.deposit(amount);
                printUserMenu();
                break;

            case 3:
                System.out.println("=== 转账 ===");
                //获取转账信息
                System.out.println("请输入转账账号: ");
                String toAccountId = in.next();
                System.out.println("请输入转账账号用户名: ");
                String toUserName = in.next();
                System.out.println("请输入转账金额: ");
                amount = in.nextDouble();

                //进行转账操作
                AccountManager.transfer(toAccountId,toUserName,amount);
                printUserMenu();
                break;

            case 4:
                System.out.println("=== 查询余额 ===");
                AccountManager.getBalance();
                printUserMenu();
                break;

            case 5:
                System.out.println("=== 查询交易记录 ===");
                AccountManager.printTransactionList();
                printUserMenu();
                break;

            case 6:
                System.out.println("=== 退出登录 ===");
                printMainMenu();
                break;

            default:
                System.out.println("输入错误!请输入相应操作对应的数字。");
                printUserMenu();
                break;
        }
    }
}

