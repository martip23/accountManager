package test;

import static org.junit.Assert.*;

import org.junit.Test;
import accountManager.model.*;

public class AccountManagerTest {
	


	@Test
	public void testAccount1() throws InvalidInputFileException {
		AccountManager accManager = new AccountManager("accounts.txt");
		AccountModel model = accManager.selectAccount(1);
		assertEquals(model.getBalance(), 50000);
		assertEquals(model.getID(), 001);
		assertEquals(model.getName(), "Patrick");
	}
	
	@Test
	public void testAccount2() throws InvalidInputFileException {
		AccountManager accManager = new AccountManager("accounts.txt");
		AccountModel model = accManager.selectAccount(2);
		assertEquals(model.getBalance(), 100000);
		assertEquals(model.getID(), 002);
		assertEquals(model.getName(), "Rodion");
	}

}
