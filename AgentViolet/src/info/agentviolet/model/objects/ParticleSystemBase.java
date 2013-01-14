package info.agentviolet.model.objects;

import java.util.Collection;
import java.util.Iterator;

import info.agentviolet.impl.Location;
import info.agentviolet.model.IAttributes;
import info.agentviolet.model.ILocation;
import info.agentviolet.model.IShape;
import info.agentviolet.model.IWorld;

public class ParticleSystemBase implements IParticleSystem {

	private ParticleIterator particleIterator = new ParticleIterator(this);
	protected ILocation location = new Location();
	protected long lastUpdateTime = System.nanoTime();
	protected boolean isActive = true;
	float[] xpos;
	float[] ypos;
	float[] xvel;
	float[] yvel;
	protected int count;

	protected void init(int count) {
		this.count = count;
		xpos = new float[count];
		ypos = new float[count];
		xvel = new float[count];
		yvel = new float[count];
	}

	@Override
	public IWorld getWorld() {
		return null;
	}

	@Override
	public ILocation getLocation() {
		return location;
	}

	@Override
	public void update() {
		location.update();
		lastUpdateTime = System.nanoTime();
	}

	@Override
	public boolean isStatic() {
		return false;
	}

	@Override
	public boolean isActive() {
		return isActive;
	}

	@Override
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public IAttributes getAttributes() {
		return null;
	}

	@Override
	public long getLastUpdateTime() {
		return lastUpdateTime;
	}

	@Override
	public IShape getShape() {
		return null;
	}

	@Override
	public Collection<IParticle> getParticles() {
		return this;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator<IParticle> iterator() {
		particleIterator.reset();
		return particleIterator;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(IParticle e) {
		return false;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends IParticle> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {
	}

	private class ParticleIterator implements Iterator<IParticle> {

		private final Particle currentParticle;
		private int currentIndex = 0;

		ParticleIterator(final ParticleSystemBase particleSystemBase) {
			currentParticle = new Particle(particleSystemBase);
		}

		@Override
		public void remove() {
		}

		@Override
		public IParticle next() {
			if (hasNext()) {
				currentIndex++;
				currentParticle.setIndex(currentIndex);
				return currentParticle;
			} else {
				return null;
			}
		}

		@Override
		public boolean hasNext() {
			return currentIndex < (size() - 1);
		}

		public void reset() {
			currentIndex = 0;
		}
	}
}
