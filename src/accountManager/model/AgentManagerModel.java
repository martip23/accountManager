/**
 * 
 */
package accountManager.model;
import java.util.ArrayList;

/**
 * @author Patrick Martinez
 * Creates agents and prevents duplicate IDs. Also ensures that each agent
 * runs on its own thread.
 */
public class AgentManagerModel {

	//List to hold running agents
	private ArrayList<AgentModel> agents = new ArrayList<AgentModel>();
	private ArrayList<Integer> agentIds = new ArrayList<Integer>();
	int agentsRunning = 0;

	/**
	 * Creates an agent and keeps track of id
	 * @param id ID of agent to be made
	 * @param accModel Model for agent to manage
	 */
	public void agentCreator(int id, AccountModel accModel) {
		for (int i = 0; i < agentsRunning; i++) {
			if (id == agents.get(i).getId()){
				// TODO Create and throw exception
				System.out.println("ID already exists");
				return;
			}
			else {
				AgentModel agModel = new AgentModel(id, accModel);
				agents.add(agModel);
				agentIds.add(id);
			}
		}
	}
}