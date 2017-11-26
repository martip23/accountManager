package accountManager.controller;
import java.util.ArrayList;

import accountManager.model.*;
import accountManager.view.*;

/**
 * Implements the commands that can be passed on to the model or view.
 * @author martip23
 */
public class AccountManagerController extends AbstractController {
	
	public ArrayList<AccountModel> initAccounts = new ArrayList<AccountModel>();
	public ArrayList<AccountModel> accounts = new ArrayList<AccountModel>();
	public Boolean modified = false;
	public int numOfAccounts;
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
		numOfAccounts = ((AccountManager)getModel()).numOfAccounts();
		for (int i = 0; i < numOfAccounts; i++)
			initAccounts.add(((AccountManager)getModel()).selectAccount(i));
		accounts = initAccounts;
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
			new AccountController(accounts.get(selectedAccount), "USD");
			
		}
		else if (option.equals(AccountManagerView.EDIT_JPY)) {
	
			new AccountController(accounts.get(selectedAccount), "JPY");
		}
		else if (option.equals(AccountManagerView.EDIT_EUR)) {

			new AccountController(accounts.get(selectedAccount), "EUR");		
		}
		else if (option.equals(AccountManagerView.SAVE)) {
			for (int i = 0; i < numOfAccounts; i++)
				((AccountManager)getModel()).updateBalance(accounts.get(i));
			((AccountManager) getModel()).saveAccounts();
		}
		else if (option.equals(AccountManagerView.EXIT)) {
			for (int i = 0; i < numOfAccounts; i++)
				((AccountManager)getModel()).updateBalance(accounts.get(i));
			if (initAccounts.equals(accounts)) 
				((AccountManager) getModel()).saveAccounts();
			System.exit(0);
		}
	}
}
