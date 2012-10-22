package info.agentviolet.examples.creatures;
import info.agentviolet.impl.World;


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
		
		Muffin muffin = new Muffin();
		muffin.getLocation().getPosition().setX(150f);
		muffin.getLocation().getPosition().setY(150f);
		addObject(muffin);
	}
	
	@Override
	public void update() {		
		super.update();
	}
	
}
