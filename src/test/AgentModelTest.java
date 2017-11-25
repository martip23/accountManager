package test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import accountManager.model.*;

import org.junit.Test;

public class AgentModelTest {

	@Test
	public void testAgentModel() {
		AccountModel accModel = new AccountModel("Patrick", 001, 500);
		AgentModel model = new AgentModel(001, accModel);
		assertEquals(001, model.getId());
		AgentModel model2 = new AgentModel(1553, accModel);
		assertEquals(1553, model2.getId());
	}

	@Test
	public void testAutoDepositAndStop1() {
		AccountModel accModel = new AccountModel("Rodion", 153, 10000);
		AgentModel agModel = new AgentModel(101, accModel);
		
		Runnable agentThread = new Runnable() {
			public void run() {
				agModel.startAutoDeposit(20000, 0.499);
			}
		};
		
		new Thread(agentThread).start();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		agModel.stopAgent();
		assertEquals(230000, accModel.getBalance());
	}
		
	@Test
	public void testAutoDepositAndStop2() {
		AccountModel accModel = new AccountModel("Steaks", 999, 0);
		AgentModel agModel = new AgentModel(998546, accModel);
		
		Runnable agentThread = new Runnable() {
			public void run() {
				agModel.startAutoDeposit(70000, 1.499);
			}
		};
		
		new Thread(agentThread).start();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		agModel.stopAgent();
		assertEquals(280000, accModel.getBalance());
	}

//	@Test
//	public void testAutoWithdraw() {
//		fail("Not yet implemented");
//	}

}
