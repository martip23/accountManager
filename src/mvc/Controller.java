package mvc;

/**
 * The Controller interface is the interface which must be implemented by
 * all classes which wish to take the role of a Controller.
 * All controllers must be able to reference a model and a view object.
 * <p>
 * The primary role of a Controller within the MVC is to determine what
 * should happen in response to user input.
 * @author martip23
 *
 */
public interface Controller {
	void setModel(Model model);
	Model getModel();
	View getView();
	void setView(View view);
}
