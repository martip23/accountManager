package accountManager.controller;
import accountManager.model.*;
import accountManager.view.*;

/**
 * Implements the commands that can be passed on to the model or view.
 * @author martip23
 */
public class AccountManagerController extends AbstractController {
	
	public Boolean modified = true;
	int selectedAccount;

	/**
	 * Registers a model and view with controller.
	 */
	public AccountManagerController(String filename) {
		try {
			setModel(new AccountManager(filename));
		} catch (InvalidInputFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setView(new AccountManagerView((AccountManager)getModel(), this));
		((AccountManager) getModel()).forceNotify();
		((JFrameView)getView()).setVisible(true);
	}
	
	/**
	 * Defines the operations that can be run.
	 * @param option Button/Action requested.
	 */
	public void operation(String option) {
		selectedAccount = ((AccountManagerView)getView()).accountList.getSelectedIndex();
		
		if (option.equals(AccountManagerView.EDIT_USD)) {
			AccountModel model = ((AccountManager)getModel()).selectAccount(selectedAccount);
			new AccountController(model, "USD");
		}
		else if (option.equals(AccountManagerView.EDIT_JPY)) {
			AccountModel model = ((AccountManager)getModel()).selectAccount(selectedAccount);
			new AccountController(model, "JPY");
		}
		else if (option.equals(AccountManagerView.EDIT_EUR)) {
			AccountModel model = ((AccountManager)getModel()).selectAccount(selectedAccount);
			new AccountController(model, "EUR");		
		}
		else if (option.equals(AccountManagerView.SAVE)) {
			((AccountManager) getModel()).saveAccounts();
		}
		else if (option.equals(AccountManagerView.EXIT)) {
			if (modified) 
				((AccountManager) getModel()).saveAccounts();
			System.exit(0);
		}
	}
}
