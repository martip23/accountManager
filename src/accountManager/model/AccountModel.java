package accountManager.model;

/**
 * Holds an account balance as an integer, exchange rates and supports
 * operations for depositing and withdrawing to and from balance.
 * Throws exceptions if unable to do any operations. 
 * @author martip23
 *
 */
public class AccountModel extends AbstractModel {
	static final double USD_TO_EUR = 0.79;
	static final double USD_TO_JPY = 94.1;
	
	/**
	 * Balance should be stored as integer in the smallest denomination
	 */
	private int balance;
	
	/**
	 * This constructor initializes the balance to the value passed.
	 * Value passed should be in USD cents.
	 * @param initialBalance This should be in USD.
	 */
	AccountModel(int initialBalance) {

	}
	
	/**
	 * Deposits money to account increasing balance
	 * @param val Amount to deposit.
	 * @param currencyCode The currency the deposit is done in.
	 */
	public void deposit(int val, String currencyCode) {
		
	}
	
	/**
	 * Withdraws money from account decreasing balance.
	 * Throws exception if withdraw would overdraw account.
	 * @param val Amount to withdraw.
	 * @throws OverdrawException If about to overdraw, throw this.
	 * @param currencyCode The currency the deposit is done in.
	 */
	public void withdraw(int val, String currencyCode) throws OverdrawException {
		
	}
}
