package accountManager.model;
import java.util.concurrent.TimeUnit;

/**
 * Holds variables needed to make automated deposit/withdraw agent work.
 * Note: This class does not make any deposits or withdraws but will
 * call on the account controller to make the actual deposits and withdraws.
 * @author martip23
 */
public class AgentModel extends AbstractModel {
	final String 
			BLOCKED = "blocked",
			RUNNING = "running",
			STOPPED = "stopped";
	
	private int id;
	private double operationsPerSecond = 0.0;
	private String state = STOPPED;
	private int amountTransferred = 0;
	private int operationsCompleted = 0;
	private int amountToChange = 0;
	private AccountModel accountModel;
	
	/**
	 * Sets ID for this agent
	 * @param id to set
	 */
	public AgentModel(int id, AccountModel model) {
		this.id = id;
		this.accountModel = model;
	}
	
	/**
	 * Does an autoDeposit cycle based on variables entered.
	 * @param value	Amount to deposit.
	 * @param operationsPerSecond Delay between operations
	 */
	synchronized public void startAutoDeposit(int value, double operationsPerSecond)
			throws IllegalArgumentException  {
		
		if (value < 0) {
			throw new IllegalArgumentException("Value cannot be negative.");
		}
		
		state = RUNNING;
		while (state != STOPPED) {
			accountModel.deposit(value);
			try {
				wait((long)(operationsPerSecond * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	/**
	 * Does an autoWithdraw cycle based on variables entered.
	 * @param value Amount to withdraw.
	 * @param currencyCode The currency the withdraw is made in.
	 */
	public void autoWithdraw(int value, String currencyCode) throws OverdrawException {
		
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the operationsPerSecond
	 */
	public double getOperationsPerSecond() {
		return operationsPerSecond;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Set the state
	 * @param state desired state
	 */
	public void stopAgent() {
		state = STOPPED;
	}
	
	public void blockAgent() {
		state = BLOCKED;
	}

	/**
	 * @return the amountTransferred
	 */
	public int getAmountTransferred() {
		return amountTransferred;
	}

	/**
	 * @return the operationsCompleted
	 */
	public int getOperationsCompleted() {
		return operationsCompleted;
	}

	/**
	 * @return the amountToChange
	 */
	public int getAmountToChange() {
		return amountToChange;
	}
}
