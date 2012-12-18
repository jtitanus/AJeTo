package info.agentviolet.world;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import info.agentviolet.impl.ObjectAttributesBase;
import info.agentviolet.impl.SpaceVector;
import info.agentviolet.impl.WorldAttributesBase;
import info.agentviolet.impl.WorldBase;
import info.agentviolet.model.ISpaceVector;
import info.agentviolet.model.IWorldObject;
import info.agentviolet.world.effects.EarthGravityEffect;

public class PhysicalWorld extends WorldBase {

	private IEffect[] effects;

	public PhysicalWorld() {
		attributes = new WorldAttributesBase();
		effects = new IEffect[1];
		effects[0] = new EarthGravityEffect();
	}

	@Override
	public void update() {
		// super.update();
		for (IWorldObject worldObject : worldObjects) {
			Shape shape1 = (Shape) worldObject.getAttributes().getAttribute(ObjectAttributesBase.SHAPE);
			// set coordinates
			if (shape1 instanceof Ellipse2D.Float) {
				((Ellipse2D.Float) shape1).x = worldObject.getLocation().getPosition().getX();
				((Ellipse2D.Float) shape1).y = worldObject.getLocation().getPosition().getY();
			} else if (shape1 instanceof Rectangle2D.Float) {
				((Rectangle2D.Float) shape1).x = worldObject.getLocation().getPosition().getX();
				((Rectangle2D.Float) shape1).y = worldObject.getLocation().getPosition().getY();
			} else {
				System.out.println("Unknown shape type. [" + shape1.getClass().getName() + "]");
			}

			if (!worldObject.isStatic()) {

				// detect collisions
				for (IWorldObject worldObject2 : worldObjects) {
					if (worldObject2 != worldObject) {
						Shape shape2 = (Shape) worldObject2.getAttributes().getAttribute(ObjectAttributesBase.SHAPE);
						if (shape1.intersects(shape2.getBounds2D())) {
							// collision
							// determine contact location							

							worldObject.getLocation().setPosition(new SpaceVector(worldObject.getLocation().getPosition().getX(), worldObject2.getLocation().getPosition().getY() - (float) (shape1.getBounds().height), worldObject.getLocation().getPosition().getZ()));
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
