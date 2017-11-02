package mvc;

/**
 * @author martip23
 * This interface must be implemented by all classes that wish to play the Model
 * role within the MVC framework.
 */
public interface Model {
	void notifyChanged(ModelEvent event);
}
