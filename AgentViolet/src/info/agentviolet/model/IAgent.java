package info.agentviolet.model;

/***
 * Agent is a world object, that can reflect on his own state and can perform a
 * task to satisfy its needs.
 * 
 */
public interface IAgent extends IWorldObject {

	INeeds getNeeds();

	ICognition getCognition();

	void setCognition(ICognition cognition);

	ITask getTask();

	void setTask(ITask task);	

}
