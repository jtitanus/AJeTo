package info.agentviolet.model;

public interface ITimeSubject {
	
	long getDeltaUpdateTime();
	
	void setDeltaUpdateTime(long deltaUpdateTime);
	
	long getLastUpdateTime();
	
	/** Triggers an automated update by the time keeper. Should trigger the specific update method below. */
	void triggerUpdate();
	
	/** Does the actual update. Every TimeSubject should implement this on his own. */
	void update();
}
