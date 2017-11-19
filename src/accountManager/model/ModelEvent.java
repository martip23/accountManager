package accountManager.model;
import java.awt.event.ActionEvent;

/**
 * Used to notify interested objects of changes in the state of a model
 * @author martip23
 *
 */
public class ModelEvent extends ActionEvent {
	
	/**
	 * Added serial version UID per IDE recommendation
	 */
	private static final long serialVersionUID = 5939937586052315280L;
	
	private int amount;
	private String currency;
	
	/**
	 * Constructor for event.
	 * @param obj Usually this.
	 * @param id Give an ID. Not used in AccountManager.
	 * @param message Name of command.
	 * @param amount Value to pass.
	 * @param currency Standard 3 letter denom. abbreviation.
	 */
	public ModelEvent (Object obj, int id, String message, int amount, String currency) {
		super( obj, id, message);
		this.amount = amount;
	}
	
	/**
	 * Getter for amount.
	 * @return Returns amount.
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Getter for currency.
	 * @return Returns currency.
	 */
	public String getCurrency() {
		return currency;
	}
}
