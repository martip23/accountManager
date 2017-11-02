package mvc;
import javax.swing.*;

/**
 * The JFrameView class is the root class of the view class hierarchy for top level
 * (swing) frames. It allows a controller and a model to be registered and can 
 * register itself with a model as an observer of that model
 * <p>
 * It extends the JFrame class
 * <p>
 * It requires the implementation of the <code>modelChanged(ModelEvetn event);</code>
 * method in order that it can work with the notification mechanism in Java.
 * @author martip23
 */
abstract public class JFrameView extends JFrame implements View, ModelListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Model model;
	private Controller controller;
	
	public JFrameView (Model model, Controller controller) {
		setModel(model);
		setController(controller);
	}
	
	public void registerWithModel( ) {
		((AbstractModel)model).addModelListener(this);
	}

	@Override
	public Controller getController() {
		return controller;
	}

	@Override
	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public Model getModel() {
		return model;
	}

	@Override
	public void setModel(Model model) {
		this.model = model;
		registerWithModel();
	}
}
