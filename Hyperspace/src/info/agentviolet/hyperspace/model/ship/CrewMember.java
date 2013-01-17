package info.agentviolet.hyperspace.model.ship;

public class CrewMember {
	
	protected SpaceShip ship;

	public CrewMember(SpaceShip ship) {
		this.ship = ship;
	}

	public SpaceShip getShip() {
		return ship;
	}
}
