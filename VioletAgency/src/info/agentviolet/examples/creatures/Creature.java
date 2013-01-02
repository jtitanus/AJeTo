package info.agentviolet.examples.creatures;

import java.awt.geom.Ellipse2D;
import info.agentviolet.impl.AgentBase;
import info.agentviolet.model.IShape;
import info.agentviolet.model.IWorld;
import info.agentviolet.world.ShapeBase;

public class Creature extends AgentBase {

	private static CreatureCognition creatureCognition = new CreatureCognition();
	private CreatureShape creatureShape = new CreatureShape();

	public Creature(IWorld world) {
		this.world = world;
		this.setCognition(creatureCognition);
		this.needs = new CreatureNeeds();
		this.attributes = new CreatureAttributes();
		creatureShape.shape.height = 25f;
		creatureShape.shape.width = 25f;
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public IShape getShape() {
		creatureShape.shape.x = getLocation().getPosition().getX();
		creatureShape.shape.y = getLocation().getPosition().getY();
		return creatureShape;
	}

	private class CreatureShape extends ShapeBase implements IShape {

		Ellipse2D.Float shape = new Ellipse2D.Float();

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
