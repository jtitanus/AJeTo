package info.agentviolet.model;

import java.util.Collection;

/***
 * Task is a set of more simple actions executed in a sequence 
 * in order to accomplish a more abstract task (e.G. seek food, goto consumable, eat)
 * */
public interface ITask {

	IAction getCurrentAction();	
	
	Collection<IAction> getActions();
	
	/*** Starts / resets the action sequence and time count. */
	void start();
	
	/*** Performs the next step update */
	void perform(IAgent agent);
	
	/*** Gets the time amount, how long this Task is already running in milliseconds. */ 
	long getRunningTime();
}
