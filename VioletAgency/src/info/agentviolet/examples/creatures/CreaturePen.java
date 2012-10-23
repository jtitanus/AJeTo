package info.agentviolet.examples.creatures;
import info.agentviolet.impl.World;

public class CreaturePen extends World {

	public CreaturePen () {
		Creature creature = new Creature(this);
		creature.getLocation().getPosition().setX(100f);
		creature.getLocation().getPosition().setY(100f);
		addObject(creature);
		
		creature = new Creature(this);
		creature.getLocation().getPosition().setX(400f);
		creature.getLocation().getPosition().setY(100f);
		addObject(creature);
		
		creature = new Creature(this);
		creature.getLocation().getPosition().setX(100f);
		creature.getLocation().getPosition().setY(400f);
		addObject(creature);
		
		creature = new Creature(this);
		creature.getLocation().getPosition().setX(400f);
		creature.getLocation().getPosition().setY(400f);
		addObject(creature);
		
		Muffin muffin = new Muffin();
		muffin.getLocation().getPosition().setX(300f);
		muffin.getLocation().getPosition().setY(300f);
		addObject(muffin);
	}
			
}
