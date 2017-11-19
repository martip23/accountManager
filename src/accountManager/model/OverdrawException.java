package accountManager.model;

/**
 * Throws exception when a withdraw would overdraw the account.
 * @author martip23
 *
 */
public class OverdrawException extends Exception {
	OverdrawException(String msg){
		super(msg);
	}
}
