package info.agentviolet.world;

import java.awt.Shape;
import info.agentviolet.impl.SpaceVector;
import info.agentviolet.impl.WorldBase;
import info.agentviolet.model.ISpaceVector;
import info.agentviolet.model.IWorldObject;
import info.agentviolet.world.physics.effects.EarthGravityEffect;

public class PhysicalWorld extends WorldBase {

	private IEffect[] effects;

	public PhysicalWorld() {
		super();
		effects = new IEffect[1];
		effects[0] = new EarthGravityEffect();
	}

	@Override
	public void update() {
		// super.update();
		for (IWorldObject worldObject : worldObjects) {

			if (!worldObject.isStatic()) {

				// detect collisions
				for (IWorldObject worldObject2 : worldObjects) {
					if (worldObject2 != worldObject) {						
						if (worldObject.getShape().checkCollision(worldObject2.getShape())) {
							// collision
							// determine contact location							

							worldObject.getLocation().setPosition(new SpaceVector(worldObject.getLocation().getPosition().getX(), worldObject2.getLocation().getPosition().getY() - (float) (((Shape)worldObject.getShape().getGraphicShape()).getBounds().height), worldObject.getLocation().getPosition().getZ()));
							// compute reaction
							// compute angle of impact

							// mirror velocity vector
							ISpaceVector vel = worldObject.getLocation().getVelocity();
							worldObject.getLocation().setVelocity(new SpaceVector(vel.getX() * -1f, vel.getY() * -1f, vel.getZ() * -1f));
						}
					}
				}
				for (IEffect effect : effects) {
					effect.apply(worldObject);
				}
				worldObject.update();
			}
		}
	}

}
