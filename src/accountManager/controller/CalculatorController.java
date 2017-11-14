package accountManager.controller;
import accountManager.model.*;
import accountManager.view.*;

public class CalculatorController extends AbstractController {
	public CalculatorController() {
		setModel(new CalculatorModel());
		setView(new CalculatorView((CalculatorModel)getModel(), this));
		((JFrameView)getView()).setVisible(true);
	}
	
	public void operation(String option){
		if(option.equals(CalculatorView.MINUS)){
			((CalculatorModel)getModel()).subtract();
		}else if(option.equals(CalculatorView.PLUS)){
			((CalculatorModel)getModel()).add();
		}else if(option.equals(CalculatorView.CLEAR)){
			((CalculatorModel)getModel()).clear();
		}else if(option.equals(CalculatorView.EQUALS)){
			((CalculatorModel)getModel()).equals();
		}else {
			((CalculatorModel)getModel()).store(Integer.parseInt(option));
		}
	}
}
