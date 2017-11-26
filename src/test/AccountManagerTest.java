package test;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import accountManager.model.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountManagerTest {
	


	@Test
	public void testReadAccount1() throws InvalidInputFileException {
		AccountManager accManager = new AccountManager("accounts.txt");
		AccountModel model = accManager.selectAccount(1);
		assertEquals(model.getBalance(), 50000);
		assertEquals(model.getID(), 001);
		assertEquals(model.getName(), "Patrick");
	}
	
	@Test
	public void testReadAccount2() throws InvalidInputFileException {
		AccountManager accManager = new AccountManager("accounts.txt");
		AccountModel model = accManager.selectAccount(2);
		assertEquals(model.getBalance(), 100000);
		assertEquals(model.getID(), 002);
		assertEquals(model.getName(), "Rodion");
	}
	
	@Test
	public void testWriteAccount1() throws InvalidInputFileException {
		AccountManager accManager = new AccountManager("accounts.txt");		
		AccountModel model = accManager.selectAccount(2);
		assertEquals(model.getBalance(), 100000);
		assertEquals(model.getID(), 002);
		assertEquals(model.getName(), "Rodion");
		
		model.deposit(150000);
		accManager.saveAccount(model);
		
		AccountManager accMan2 = new AccountManager("accounts.txt");
		model = accManager.selectAccount(2);
		assertEquals(model.getBalance(), 250000);
		assertEquals(model.getID(), 002);
		assertEquals(model.getName(), "Rodion");
		
		try {
			model.withdraw(150000);
		} catch (OverdrawException e) {
			e.printStackTrace();
		}
		
		accMan2.saveAccount(model);
	}

}
