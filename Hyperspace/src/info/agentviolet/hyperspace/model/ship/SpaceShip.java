package info.agentviolet.hyperspace.model.ship;

import info.agentviolet.hyperspace.model.DamageType;
import info.agentviolet.impl.TimeSubject;

public class SpaceShip extends TimeSubject implements ITargetable {
	
	protected String name;
	protected final float netMass;	
	
	protected Armament armament;
	protected Storage storage;
	protected ShieldGenerator shieldGen;
	protected Reactor reactor;
	protected Hyperdrive hyperdrive;
	protected LifeSupport lifeSupport;
	protected Hull hull;
			
	public SpaceShip(String name, float netMass) {
		this.name = name;
		this.netMass = netMass;
	}
	/**
	 * @return mass in tons
	 */
	public float getMass() {
		return 
				  hull.getMass()
				+ armament.getMass() 
				+ storage.getMass() 
				+ shieldGen.getMass() 
				+ reactor.getMass() 
				+ hyperdrive.getMass() 
				+ lifeSupport.getMass();
	}

	public float getNetMass() {		
		return netMass;
	}		

	public void receiveDamage(float damage, DamageType type) {
		if(type==DamageType.LASER) {
			damage = shieldGen.receiveDamage(damage);
			if(damage>0f) hull.receiveDamage(damage, type);
		}
		else if(type==DamageType.ION) {
			damage = shieldGen.receiveDamage(damage);
		}
		else  if(type==DamageType.EXPLOSIVE) {
			damage = shieldGen.receiveDamage(damage/2f);
			if(damage>0f) hull.receiveDamage(damage, type);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public Armament getArmament() {
		return armament;
	}

	void setArmament(Armament armament) {
		this.armament = armament;
	}

	public Storage getStorage() {
		return storage;
	}

	void setStorage(Storage storage) {
		this.storage = storage;
	}

	public ShieldGenerator getShieldGen() {
		return shieldGen;
	}

	void setShieldGen(ShieldGenerator shieldGen) {
		this.shieldGen = shieldGen;
	}

	public Reactor getReactor() {
		return reactor;
	}

	void setReactor(Reactor reactor) {
		this.reactor = reactor;
	}

	public Hyperdrive getHyperdrive() {
		return hyperdrive;
	}

	void setHyperdrive(Hyperdrive hyperdrive) {
		this.hyperdrive = hyperdrive;
	}

	public LifeSupport getLifeSupport() {
		return lifeSupport;
	}

	void setLifeSupport(LifeSupport lifeSupport) {
		this.lifeSupport = lifeSupport;
	}

	public Hull getHull() {
		return hull;
	}
	
	public void setHull(Hull hull) {
		this.hull = hull;
	}

	public int getPowerConsumption() {		
		return    armament.getPowerConsumption() 				
				+ shieldGen.getPowerConsumption()  
				+ hyperdrive.getPowerConsumption() 
				+ lifeSupport.getPowerConsumption();
	}
	@Override
	public void update() {
		armament.update();
		shieldGen.update();
	}

}
