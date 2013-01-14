package info.agentviolet.model.objects;

import java.util.Random;


public class StarfieldParticleSystem extends ParticleSystemBase {

	private Random rnd = new Random();
	
	public StarfieldParticleSystem(int starsCount) {		
		init(starsCount);
		for(IParticle particle : getParticles()) {
			particle.setX(rnd.nextFloat()*2048);
			particle.setY(rnd.nextFloat()*1280);
			particle.setXVel(-rnd.nextFloat()*10);			
		}
	}
	
	@Override
	public void update() {
		super.update();
		for(IParticle particle : getParticles()) {
			particle.update();
		}
	}

}
