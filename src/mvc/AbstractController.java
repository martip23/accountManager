package mvc;

/**
 * The root of the Controller class hierarchy is the AbstractController class.
 * This class defines all the basic facilities required to implement a
 * controller. That is, it allows a view and model to be linked to the
 * controller.
 * <p>
 * It also provides a set of constructors and set and get methods for views
 * and models
 * @author martip23
 *
 */
public class AbstractController implements Controller {
	
	private View view;
	private Model model;

	@Override
	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public Model getModel() {
		return model;
	}

	@Override
	public View getView() {
		return view;
	}

	@Override
	public void setView(View view) {
		this.view = view;

	}

}
