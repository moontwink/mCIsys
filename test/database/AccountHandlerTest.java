package database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import model.AccountType;
import model.BusinessAccount;
import model.CheckingsAccount;
import model.SavingsAccount;
import model.UserModel;

import org.junit.Test;

import exception.WithdrawalException;

public class AccountHandlerTest {

	@Test(expected = NullPointerException.class)
	public void testInitAccount() {
		AccountHandler accountHandler = new AccountHandler();
		accountHandler.initAccount(null);
	}
	
	@Test
	public void testInitAccountReturn() {
		UserModel user = new UserModel("Nancy", "Naval", "moontwink", "helloworld");
		AccountHandler accountHandler = new AccountHandler();
		UserModel newuser = accountHandler.initAccount(user);
		assertSame(user, newuser);
	}

	@Test
	public void testDepositCash() {
		AccountHandler accountHandler = new AccountHandler();
		UserModel useraccount = new UserModel("Nancy", "Naval", "moontwink", "helloworld");
		useraccount.setSavingsAccount(new SavingsAccount(10000));
		useraccount.setBusinessAccount(new BusinessAccount(20000));
		useraccount.setCheckingsAccount(new CheckingsAccount(30000));
		int actual = accountHandler.depositCash(1000.0, useraccount, AccountType.SAVINGS);
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test(expected = WithdrawalException.class)
	public void testWithdrawCash() throws WithdrawalException {
		AccountHandler accountHandler = new AccountHandler();
		UserModel useraccount = new UserModel("Nancy", "Naval", "moontwink", "helloworld");
		useraccount.setSavingsAccount(new SavingsAccount(10000));
		useraccount.setBusinessAccount(new BusinessAccount(20000));
		useraccount.setCheckingsAccount(new CheckingsAccount(30000));
		int actual = accountHandler.withdrawCash(100002.0, useraccount, AccountType.SAVINGS);
		int expected = 0;
		assertEquals(expected, actual);
	}

}
