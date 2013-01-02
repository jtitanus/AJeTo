package info.agentviolet.examples.creatures;

import java.awt.geom.Ellipse2D;

import info.agentviolet.impl.WorldObjectBase;
import info.agentviolet.model.IAgent;
import info.agentviolet.model.IShape;
import info.agentviolet.model.IWorld;
import info.agentviolet.model.objectAttributes.IConsumable;
import info.agentviolet.world.ShapeBase;

public class Muffin extends WorldObjectBase implements IConsumable {

	private MuffinShape muffinShape = new MuffinShape();

	public Muffin(IWorld world) {
		this.world = world;
		muffinShape.shape.height = 25f;
		muffinShape.shape.width = 25f;
	}

	@Override
	public String getEatMessage() {
		return "Yum!";
	}

	@Override
	public boolean isStatic() {
		return true;
	}

	@Override
	public void consume(IAgent subject) {
		this.setActive(false);
	}

	@Override
	public float getSatisfactionGain() {
		return 0.25f;
	}

	@Override
	public IShape getShape() {
		muffinShape.shape.x = getLocation().getPosition().getX();
		muffinShape.shape.y = getLocation().getPosition().getY();
		return muffinShape;
	}

	private class MuffinShape extends ShapeBase implements IShape {

		private Ellipse2D.Float shape = new Ellipse2D.Float();

		@Override
		public Object getGraphicShape() {
			return shape;
		}

		@Override
		public Class<?> getType() {
			return Ellipse2D.Float.class;
		}

	}
}
