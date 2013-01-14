package info.agentviolet.model.objects;

import java.util.Collection;

import info.agentviolet.model.IWorldObject;

public interface IParticleSystem extends IWorldObject, Collection<IParticle>{

	Collection<IParticle> getParticles();
	
}
