package info.agentviolet.hyperspace.model.ship.designs;

import info.agentviolet.hyperspace.model.ship.Armament;
import info.agentviolet.hyperspace.model.ship.LifeSupport;
import info.agentviolet.hyperspace.model.ship.SpaceShip;
import info.agentviolet.hyperspace.model.ship.Storage;
import info.agentviolet.hyperspace.model.ship.aggregates.HyperdriveA;
import info.agentviolet.hyperspace.model.ship.aggregates.ReactorA;
import info.agentviolet.hyperspace.model.ship.aggregates.ShieldGeneratorA;
import info.agentviolet.hyperspace.model.ship.aggregates.StandardHull;

public class Hybris extends SpaceShip {

	public Hybris() {
		super(50f);
		hyperdrive = new HyperdriveA(this);
		armament = new Armament(this);
		lifeSupport = new LifeSupport(this);
		reactor = new ReactorA(this);
		shieldGen = new ShieldGeneratorA(this);
		storage = new Storage(this);
		hull = new StandardHull(this, 120f);
	}
}
