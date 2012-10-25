package info.agentviolet.model;

import java.util.Date;

/***
 * Agent is a world object, that can reflect on his own state and can perform an action
 * to satisfy its needs. 
 *
 */
public interface IAgent extends IWorldObject {

	INeeds getNeeds();
	
	ICognition getCognition();
	
	void setCognition(ICognition cognition);
	
	IAction getCurrentAction();
	
	void setCurrentAction(IAction action);
	
	Date getLastUpdateTime();
	
}
