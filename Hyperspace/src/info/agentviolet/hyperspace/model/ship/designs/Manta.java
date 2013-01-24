package info.agentviolet.hyperspace.model.ship.designs;

import info.agentviolet.hyperspace.model.ship.Armament;
import info.agentviolet.hyperspace.model.ship.LifeSupport;
import info.agentviolet.hyperspace.model.ship.SpaceShip;
import info.agentviolet.hyperspace.model.ship.Storage;
import info.agentviolet.hyperspace.model.ship.aggregates.HyperdriveA;
import info.agentviolet.hyperspace.model.ship.aggregates.ReactorA;
import info.agentviolet.hyperspace.model.ship.aggregates.ShieldGeneratorA;
import info.agentviolet.hyperspace.model.ship.aggregates.StandardHull;

public class Manta extends SpaceShip {

	public Manta() {
		super("Manta", 40f);
		hyperdrive = new HyperdriveA(this);
		armament = new Armament(this, 2);
		lifeSupport = new LifeSupport(this);
		reactor = new ReactorA(this);
		shieldGen = new ShieldGeneratorA(this);
		storage = new Storage(this);
		hull = new StandardHull(this, 80f);
	}
}
