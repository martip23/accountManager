/**
 * 
 */
package accountManager.model;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author martip23
 * Abstract root class of Model hierarchy - provides basic
 * notification behavior
 */
public class AbstractModel implements Model {
	
	@SuppressWarnings("rawtypes")
	private ArrayList listeners = new ArrayList(5);

	@SuppressWarnings("rawtypes")
	@Override
	/**
	 * Method that is called by subclasses of AbstractModel when they want to
	 * notify other classes of changes to themselves.
	 */
	public void notifyChanged(ModelEvent event) {
		ArrayList list = (ArrayList)listeners.clone();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				ModelListener ml = (ModelListener)it.next();
					ml.modelChanged(event);
			}
	}
	
	/**
	 * Add a ModelListener to the list of objects interested in ModelEvents
	 */
	@SuppressWarnings("unchecked")
	public void addModelListener(ModelListener l) {
		listeners.add(l);
	}
	
	/**
	 * Remove a ModelListener from the list of objects interested in ModelEvents
	 */
	public void removeModelListener(ModelListener l) {
		listeners.remove(l);
	}

}
