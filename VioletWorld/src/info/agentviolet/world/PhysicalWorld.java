package info.agentviolet.world;

import info.agentviolet.impl.WorldAttributesBase;
import info.agentviolet.impl.WorldBase;
import info.agentviolet.model.IWorldObject;
import info.agentviolet.world.effects.EarthGravityEffect;

public class PhysicalWorld extends WorldBase {

	IEffect[] effects;

	public PhysicalWorld() {
		attributes = new WorldAttributesBase();
		effects = new IEffect[1];
		effects[0] = new EarthGravityEffect();
	}

	@Override
	public void update() {
		super.update();
		for (IWorldObject worldObject : worldObjects) {
			worldObject.update();
			if (!worldObject.isStatic()) {
				for (IEffect effect : effects) {
					effect.apply(worldObject);
				}
			}
		}
	}

}
