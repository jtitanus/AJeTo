package info.agentviolet.world;

import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

import info.agentviolet.impl.ObjectAttributesBase;
import info.agentviolet.impl.SpaceVector;
import info.agentviolet.impl.WorldAttributesBase;
import info.agentviolet.impl.WorldBase;
import info.agentviolet.model.ISpaceVector;
import info.agentviolet.model.IWorldObject;
import info.agentviolet.world.effects.EarthGravityEffect;

public class PhysicalWorld extends WorldBase {

	private IEffect[] effects;
	private List<IWorldObject> collisionList = new ArrayList<IWorldObject>();

	public PhysicalWorld() {
		attributes = new WorldAttributesBase();
		effects = new IEffect[1];
		effects[0] = new EarthGravityEffect();
	}

	@Override
	public void update() {
		// super.update();
		for (IWorldObject worldObject : worldObjects) {
			if (!worldObject.isStatic()) {
				for (IEffect effect : effects) {
					effect.apply(worldObject);
				}
				// detect collisions
				collisionList.clear();
				Shape shape1 = (Shape) worldObject.getAttributes().getAttribute(ObjectAttributesBase.SHAPE);
				for (IWorldObject worldObject2 : worldObjects) {
					if (worldObject2 != worldObject) {
						Shape shape2 = (Shape) worldObject2.getAttributes().getAttribute(ObjectAttributesBase.SHAPE);
						if (shape1.intersects(shape2.getBounds2D())) {
							collisionList.add(worldObject2);
						}
					}
				}
				// compute reaction
				// compute angle of impact

				// mirror velocity vector
				if (!collisionList.isEmpty()) {
					ISpaceVector vel = worldObject.getLocation().getVelocity();
					worldObject.getLocation().setVelocity(new SpaceVector(vel.getX() * -1f, vel.getY() * -1f, vel.getZ() * -1f));
				}
				worldObject.update();
			}
		}
	}

}
