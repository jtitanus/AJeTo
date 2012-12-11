package info.agentviolet.world.effects;

import info.agentviolet.impl.ObjectAttributesBase;
import info.agentviolet.impl.SpaceVector;
import info.agentviolet.impl.WorldAttributesBase;
import info.agentviolet.model.IWorldObject;
import info.agentviolet.world.IEffect;

public class EarthGravityEffect implements IEffect {

	@Override
	public void apply(IWorldObject worldObject) {
		float verticalV = (float) worldObject.getAttributes().getAttribute(ObjectAttributesBase.MASS) * 9.81f / (1000f / (int) worldObject.getWorld().getAttributes().getAttribute(WorldAttributesBase.UPDATE_TIME));
		
		worldObject.getLocation().setVelocity(new SpaceVector(
				worldObject.getLocation().getVelocity().getX(),
				worldObject.getLocation().getVelocity().getY() + verticalV,
				worldObject.getLocation().getVelocity().getZ()));
	}

}
