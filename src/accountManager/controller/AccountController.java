package accountManager.controller;
import accountManager.model.*;
import accountManager.util.InputParsing;
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
		if (option.equals(AccountView.DEPOSIT)) {
			String inputText = ((AccountView)getView()).amountField.getText();
			int value = InputParsing.inputToInt(inputText);
			
//			if (inputText.contains(".")) {
//				int i = inputText.indexOf('.');
//				StringBuilder sb = new StringBuilder(inputText);
//				sb.deleteCharAt(i);
//				inputText = sb.toString();
//				inputText.substring(0, i+2);
//				value = Integer.parseInt(inputText);
//				
//			}
//			else { value = (Integer.parseInt(inputText) * 100); }
			
			((AccountModel)getModel()).deposit(value);
		}
		else if (option.equals(AccountView.WITHDRAW)) {
			int value = Integer.parseInt(((AccountView)getView()).amountField.getText());
			try {
				((AccountModel)getModel()).withdraw(value);
			} catch (OverdrawException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (option.equals(AccountView.DISMISS)) {
			((JFrameView)getView()).setVisible(false);
		}
		else if (option.equals(AccountView.CREATE_W_AGENT)) {
			System.out.print("AGENT CREATED");
		}
		else if (option.equals(AccountView.CREATE_D_AGENT)) {
			System.out.print("AGENT CREATED");
		}
		
	}
}
