package info.agentviolet.model;

/***
 * 
 * Agent
 *
 */
public interface IAgent extends IWorldObject {

	//INeeds getNeeds();
	
	ICognition getCognition();
	
	void setCognition(ICognition cognition);
	
}
