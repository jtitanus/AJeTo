package info.agentviolet.model;

public interface INeed {

	int getPriority();
	
	float getSatisfactionLevel();
	
	void increaseSatisfactionLevel(float satisfactionLevelPlus);
	
	void decreaseSatisfactionLevel(float satisfactionLevelMinus);
	
}
