package accountManager.model;

/**
 * Holds variables needed to make automated deposit/withdraw agent work.
 * Note: This class does not make any deposits or withdraws but will
 * call on the account controller to make the actual deposits and withdraws.
 * @author martip23
 */
public class AgentModel extends AbstractModel {
	private int ID;
	private double operationsPerSecond = 0.0;
	private String state;
	private int amountTransferred = 0;
	private int operationsCompleted = 0;
	private int amountToChange = 0;
	
	/**
	 * Does an autoDeposit cycle based on variables entered.
	 * @param value	Amount to deposit.
	 * @param currencyCode The currency the deposit is done in.
	 */
	public void autoDeposit(int value, String currencyCode) {
		
	}
	
	/**
	 * Does an autoWithdraw cycle based on variables entered.
	 * @param value Amount to withdraw.
	 * @param currencyCode The currency the withdraw is made in.
	 */
	public void autoWithdraw(int value, String currencyCode) throws OverdrawException {
		
	}
}
