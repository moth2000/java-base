package org.day7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountManagerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void openAccountTest() {
        //正确开户
        Account account = AccountManager.openAccount("张三","123456","123456");
        assertNotNull(account);
        assertNotNull(account.accountId);
        //错误开户1:两次密码不一致
        Account account1 = AccountManager.openAccount("张三","1234561","123456");
        assertNull(account1);
        //错误开户2:用户名为空
        Account account2 = AccountManager.openAccount("","123456","123456");
        assertNull(account2);
        //错误开户3:用户名长度为0
        Account account3 = AccountManager.openAccount(null,"123456","123456");
        assertNull(account3);
    }

    @Test
    public void loginAccountTest() {
        Account account = AccountManager.openAccount("张三","123456","123456");
        //正确登录
        assertTrue(AccountManager.loginAccount(account.accountId, "123456"));
        //错误登录1:密码不一致
        assertFalse(AccountManager.loginAccount(account.accountId, "1234561"));
        //错误登录2:用户名不存在
        assertFalse(AccountManager.loginAccount(null, "123456"));
        assertFalse(AccountManager.loginAccount("", "1234561"));
    }

    @Test
    public void depositTest() {
        Account account = AccountManager.openAccount("张三","123456","123456");
        assertNotNull(account);
        assertNotNull(account.accountId);
        AccountManager.loginAccount(account.accountId, "123456");
        //正确存钱
        AccountManager.deposit(100);
        assertTrue(account.balance == 100);
        //错误存钱
        AccountManager.deposit(-1);
        assertTrue(account.balance == 100);
    }

    @Test
    public void withdrawTest() {
        Account account = AccountManager.openAccount("张三","123456","123456");
        assertNotNull(account);
        assertNotNull(account.accountId);
        AccountManager.loginAccount(account.accountId, "123456");
        AccountManager.deposit(100);
        //正确取钱
        AccountManager.withdraw(50);
        assertTrue(account.balance == 50);
        //错误取钱
        AccountManager.withdraw(120);
        assertTrue(account.balance == 50);
        AccountManager.withdraw(-1);
        assertTrue(account.balance == 50);
    }

    @Test
    public void getBalanceTest() {
        Account account1 = AccountManager.openAccount("张三","123456","123456");
        Account account2 = AccountManager.openAccount("李四","123456","123456");
        AccountManager.loginAccount(account1.accountId, "123456");
        AccountManager.deposit(100);
        AccountManager.withdraw(10);
        AccountManager.transfer(account2.accountId, "李四",50);
        AccountManager.getBalance();
    }

    @Test
    public void transferTest() {
        Account account1 = AccountManager.openAccount("张三","123456","123456");
        Account account2 = AccountManager.openAccount("李四","123456","123456");
        AccountManager.loginAccount(account1.accountId, "123456");
        AccountManager.deposit(100);
        //正确转账
        AccountManager.transfer(account2.accountId, "李四",50);
        assertTrue(account2.balance == 50);
        //错误转账1:账号不存在
        AccountManager.transfer("1", "李四",50);
        assertTrue(account2.balance == 50);
        //错误转账2:用户名错误
        AccountManager.transfer(account2.accountId, "王五",50);
        assertTrue(account2.balance == 50);
        //错误转账3:超过余额
        AccountManager.transfer(account2.accountId, "李四",60);
        assertFalse(account2.balance == 110);

    }

    @Test
    public void printTransactionListTest() {
        Account account1 = AccountManager.openAccount("张三","123456","123456");
        Account account2 = AccountManager.openAccount("李四","123456","123456");
        AccountManager.loginAccount(account1.accountId, "123456");
        AccountManager.deposit(100);
        AccountManager.withdraw(10);
        AccountManager.transfer(account2.accountId, "李四",50);
        AccountManager.printTransactionList();
    }
}