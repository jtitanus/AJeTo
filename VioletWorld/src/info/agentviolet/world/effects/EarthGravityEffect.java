package info.agentviolet.world.effects;

import info.agentviolet.impl.ObjectAttributesBase;
import info.agentviolet.impl.SpaceVector;
import info.agentviolet.impl.WorldAttributesBase;
import info.agentviolet.model.ISpaceVector;
import info.agentviolet.model.IWorldObject;
import info.agentviolet.world.IEffect;

public class EarthGravityEffect implements IEffect {

	@Override
	public void apply(IWorldObject worldObject) {
		int deltMs = (int) worldObject.getWorld().getAttributes().getAttribute(WorldAttributesBase.DELTA_TIME);
		float verticalV = (float) worldObject.getAttributes().getAttribute(ObjectAttributesBase.MASS) * 9.81f;
		verticalV = verticalV / (1000f / deltMs);
		ISpaceVector vel =	worldObject.getLocation().getVelocity();
		worldObject.getLocation().setVelocity(new SpaceVector(vel.getX(), vel.getY() + verticalV, vel.getZ()));
	}

}
