package accountManager.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountModelTest {

	@Test
	public void testAccountModel() {
		AccountModel model = new AccountModel(500, 001, "Patrick");
		assertEquals(500, model.getBalance());
		assertEquals(001, model.getID());
		assertEquals("Patrick", model.getName());
	}

	@Test
	public void testDeposit() {
		AccountModel model = new AccountModel(500, 001, "Patrick");
		model.deposit(500);
		assertEquals(1000, model.getBalance());
		model.deposit(200);
		assertEquals(1200, model.getBalance());
		model.deposit(-200);
		assertEquals(1200, model.getBalance());
	}

	@Test
	public void testWithdraw() {
		fail("Not yet implemented");
	}

	@Test
	public void testConvertToUSD() {
		fail("Not yet implemented");
	}

}
