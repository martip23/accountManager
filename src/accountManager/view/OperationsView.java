package accountManager.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import accountManager.controller.*;
import accountManager.model.*;

/**
 * Implements the GUI and I/O of GUI. Creates listeners and event 
 * generators to work with Model & Controller.
 * @author martip23
 *
 */
public class OperationsView extends JFrameView {

	/**
	 * Creates Account Manager view and registers model & controller.
	 * @param model Model to register with view.
	 * @param controller Controller to register with view.
	 */
	public OperationsView(AccountModel model, AccountController controller) {
		super(model, controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void modelChanged(ModelEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	class Handler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
