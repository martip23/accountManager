package accountManager.controller;
import accountManager.model.*;
import accountManager.view.*;

/**
 * Implements the commands that can be passed on to the model or view.
 * @author martip23
 */
public class AccountManagerController extends AbstractController {

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
		
	}
}
