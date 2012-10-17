package info.agentviolet.examples.creatures;
import info.agentviolet.impl.World;
import info.agentviolet.model.IPresentationContext;


public class CreaturePen extends World {

	public CreaturePen () {
		Creature creature = new Creature();
		creature.getLocation().getPosition().setX(100f);
		creature.getLocation().getPosition().setY(100f);
		addObject(creature);
		
		creature = new Creature();
		creature.getLocation().getPosition().setX(200f);
		creature.getLocation().getPosition().setY(100f);
		addObject(creature);
		
		creature = new Creature();
		creature.getLocation().getPosition().setX(100f);
		creature.getLocation().getPosition().setY(200f);
		addObject(creature);
		
		creature = new Creature();
		creature.getLocation().getPosition().setX(200f);
		creature.getLocation().getPosition().setY(200f);
		addObject(creature);
	}
	
	@Override
	public void update() {		
		super.update();
	}
	
	@Override
	public void draw(IPresentationContext context) {
		super.draw(context);
	}
}
