package info.agentviolet.model.objects;

import java.util.Random;


public class StarfieldParticleSystem extends ParticleSystemBase {

	private Random rnd = new Random();
	
	
	public StarfieldParticleSystem(int starsCount) {		
		init(starsCount);
		for(IParticle particle : getParticles()) {
			particle.setX(rnd.nextFloat()*2048f);
			particle.setY(rnd.nextFloat()*1280f);
			particle.setXVel(-rnd.nextFloat()*10f);			
		}
	}
	
	@Override
	public void update() {
		super.update();
		for(IParticle particle : getParticles()) {
			particle.update();
			if(particle.getX()<0){
				particle.setX(2048f);
				particle.setY(rnd.nextFloat()*1280f);;
			}
		}
	}

}
