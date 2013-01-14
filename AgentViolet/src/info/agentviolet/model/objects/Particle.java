package info.agentviolet.model.objects;

public class Particle implements IParticle {

	private int index = 0;
	private final ParticleSystemBase particleSystemBase;
	
	public Particle(final ParticleSystemBase particleSystemBase) {
		this.particleSystemBase = particleSystemBase;
	}
	
	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public float getX() {		
		return particleSystemBase.xpos[index];
	}

	@Override
	public float getY() {
		return particleSystemBase.ypos[index];
	}

	@Override
	public float getXVel() {		
		return particleSystemBase.xvel[index];
	}

	@Override
	public float getYVel() {
		return particleSystemBase.yvel[index];
	}

	@Override
	public void setX(float x) {
		particleSystemBase.xpos[index] = x;
	}

	@Override
	public void setY(float y) {
		particleSystemBase.ypos[index] = y;
	}

	@Override
	public void setXVel(float velX) {
		particleSystemBase.xvel[index] = velX;
	}

	@Override
	public void setYVel(float velY) {
		particleSystemBase.yvel[index] = velY;
	}

	@Override
	public void update() {		
		setX(getX() + getXVel());
		setY(getY() + getYVel());
	}

}
