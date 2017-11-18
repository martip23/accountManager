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
	
	private int balance;
		
	AccountModel(int initialBalance) {
		balance = initialBalance;
	}
}
