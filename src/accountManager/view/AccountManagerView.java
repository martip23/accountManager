package accountManager.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import accountManager.controller.*;
import accountManager.model.*;

public class AccountManagerView extends JFrameView {

	public AccountManagerView(AccountModel model, AccountController controller) {
		super(model, controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void modelChanged(ModelEvent event) {
		// TODO Auto-generated method stub
		
	}

}
