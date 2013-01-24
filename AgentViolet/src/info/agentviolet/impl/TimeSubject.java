package info.agentviolet.impl;

import info.agentviolet.model.ITimeSubject;

public abstract class TimeSubject implements ITimeSubject {

	protected long deltaUpdateTime = 3000000000000L; // 30 milliseconds
	protected long lastUpdateTime = Long.MIN_VALUE;
	
	@Override
	public long getDeltaUpdateTime() {
		return deltaUpdateTime;
	}

	@Override
	public void setDeltaUpdateTime(long deltaUpdateTime) {
		
	}

	@Override
	public long getLastUpdateTime() {
		return lastUpdateTime;
	}

	@Override
	public void triggerUpdate() {
		if(canUpdate()) {
			update();
			lastUpdateTime = System.nanoTime();
		}		
	}

	private boolean canUpdate() {
		return System.nanoTime() - lastUpdateTime > deltaUpdateTime;
	}

}
