package mvc;
import java.awt.event.ActionEvent;

/**
 * Used to notify interested objects of changes in the state of a model
 * @author martip23
 *
 */
public class ModelEvent extends ActionEvent {
	
	private int amount;
	
	public ModelEvent (Object obj, int id, String message, int amount) {
		super( obj, id, message);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
}
