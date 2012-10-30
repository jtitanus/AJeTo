package info.agentviolet.impl;

import info.agentviolet.model.IActionResult;

public class ActionResultBase implements IActionResult {

	public static final ActionResultBase FINISHED = new ActionResultBase(true);
	public static final ActionResultBase UNFINISHED = new ActionResultBase(false);
	
	private boolean finished = false;
	
	/*** A default ActionResult instance, finished == false */
	public ActionResultBase() {}
	
	public ActionResultBase(boolean isFinished) {		
		this.finished = isFinished;
	}
	
	@Override
	public boolean isFinished() {		
		return finished;
	}

	@Override
	public int getPercentageCompleted() {		
		return finished ? 100 : 0;
	}

}
