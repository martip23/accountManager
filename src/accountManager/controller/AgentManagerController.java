package accountManager.controller;
import java.util.ArrayList;

import accountManager.model.*;
import accountManager.view.*;

/**
 * Implements the commands that can be passed on to the model or view.
 * @author martip23
 */
public class AgentManagerController extends AbstractController {


	/**
	 * Registers a model and view with controller.
	 */
	public AgentManagerController(AccountModel model) {
		setModel(new AgentManagerModel());

		setView(new AgentManagerView((AgentManagerModel)getModel(), this));
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