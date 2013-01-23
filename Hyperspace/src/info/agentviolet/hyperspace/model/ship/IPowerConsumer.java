package info.agentviolet.hyperspace.model.ship;

public interface IPowerConsumer extends IShipAggregate {

	boolean isActivated();
	
	void switchActivation();
	
	int getPowerConsumption();
}
