package accountManager.model;

/**
 * Holds an account balance as an integer, exchange rates and supports
 * operations for depositing and withdrawing to and from balance.
 * Throws exceptions if unable to do any operations. 
 * @author martip23
 *
 */
public class AccountModel extends AbstractModel {
	
	// Conversion factors
	static final double USD_TO_EUR = 0.79;
	static final double USD_TO_JPY = 94.1;
	
	public String currentCurrency = "USD";
	
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
		balance = initialBalance;
		ModelEvent me = new ModelEvent(this, 1, "", balance, "USD");
		notifyChanged(me);
	}
	
	/**
	 * Deposits money to account increasing balance
	 * @param val Amount to deposit.
	 * @param currencyCode The currency the deposit is done in.
	 * @TODO ask where currency conversions should be done.
	 */
	public void deposit(int val) {
		balance += val;
		ModelEvent me = new ModelEvent(this, 1, "", balance, "USD");
		notifyChanged(me);
	}
	
	/**
	 * Withdraws money from account decreasing balance.
	 * Throws exception if withdraw would overdraw account.
	 * @param val Amount to withdraw.
	 * @throws OverdrawException If about to overdraw, throw this.
	 * @param currencyCode The currency the deposit is done in.
	 * @TODO Should be updated for other currencies?
	 */
	public void withdraw(int val) throws OverdrawException {
		if(balance < val) throw new OverdrawException(
				"Insufficient funds: amount to withdraw " + val + 
				" is greater than available funds " + balance);
	}
	
	/**
	 * Convert whatever denomination being used to USD. Currency to be used
	 * is defined in variable currentCurrency.
	 * @param val Value to change to USD.
	 * @return Value in dollars.
	 */
	public int convertToUSD(int val) {
		switch(currentCurrency) {
			case "USD": break;
			case "EUR": val = (int)(val * (1/USD_TO_EUR));
						break;
			case "JPY": val = (int)(val * (1/USD_TO_JPY));
						break;
		}
		return val;
	}
}
