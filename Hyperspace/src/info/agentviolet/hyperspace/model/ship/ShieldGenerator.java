package info.agentviolet.hyperspace.model.ship;

public abstract class ShieldGenerator implements IPowerConsumer {

	protected SpaceShip ship;
	protected final float maxCapacity;
	protected float currentCapacity = 0f;
	protected boolean isActivated = true;

	public ShieldGenerator(SpaceShip ship, float maxCapacity) {
		this.ship = ship;
		this.maxCapacity = maxCapacity;
	}

	@Override
	public SpaceShip getShip() {
		return ship;
	}

	public void update() {
		if (isActivated) {
			if (currentCapacity < maxCapacity) {
				currentCapacity++;
			}
		} else {
			currentCapacity--;
			if (currentCapacity < 0f) currentCapacity = 0f;
		}
	}

	@Override
	public boolean isActivated() {
		return isActivated;
	}

	@Override
	public void switchActivation() {
		isActivated = !isActivated;
	}

	public float receiveDamage(float damage) {
		currentCapacity -= damage;
		float retVal = currentCapacity<0 ? Math.abs(currentCapacity):0f;
		if (currentCapacity < 0f) currentCapacity = 0f;
		return retVal;
	}

	public float getCurrentCapacity() {
		return currentCapacity;
	}
}
