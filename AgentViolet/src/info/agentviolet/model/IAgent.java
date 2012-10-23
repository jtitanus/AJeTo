package info.agentviolet.model;

/***
 * 
 * Agent is a worldobject, that can reflect on his own state and needs and do an action
 * to satisfy his needs. 
 *
 */
public interface IAgent extends IWorldObject {

	INeeds getNeeds();
	
	ICognition getCognition();
	
	void setCognition(ICognition cognition);
	
	IAction getCurrentAction();
	
	void setCurrentAction(IAction action);
	
}
