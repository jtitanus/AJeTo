package info.agentviolet.examples.creatures;
import info.agentviolet.impl.SpaceVector;
import info.agentviolet.impl.World;

public class CreaturePen extends World {

	public CreaturePen () {
		Creature creature = new Creature(this);
		creature.getLocation().setPosition(new SpaceVector(100f, 100f, 0f));		
		addObject(creature);
		
		creature = new Creature(this);
		creature.getLocation().setPosition(new SpaceVector(400f, 100f, 0f));		
		addObject(creature);
		
		creature = new Creature(this);
		creature.getLocation().setPosition(new SpaceVector(100f, 400f, 0f));
		addObject(creature);
		
		creature = new Creature(this);
		creature.getLocation().setPosition(new SpaceVector(400f, 400f, 0f));
		addObject(creature);
		
		Muffin muffin = new Muffin(this);
		muffin.getLocation().setPosition(new SpaceVector(350f, 350f, 0f));
		addObject(muffin);
	}
			
}
