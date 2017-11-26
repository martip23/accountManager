package accountManager.controller;
import accountManager.model.*;
import accountManager.view.*;

/**
 * Implements the commands that can be passed on to the model or view.
 * @author martip23
 */
public class AccountController extends AbstractController {
	
	public String editCurrencyType = "USD";

	/**
	 * Registers a model and view with controller.
	 */
	public AccountController(AccountModel model, String currency) {
		setModel(model);
		setView(new AccountView((AccountModel)getModel(), this));
		((JFrameView)getView()).setVisible(true);
	}
	
	/**
	 * Defines the operations that can be run.
	 * @param option Button/Action requested.
	 */
	public void operation(String option) {
		
	}
}
