package info.agentviolet.impl;

import info.agentviolet.model.IActionResult;

public class ActionResultBase implements IActionResult {

	public static final ActionResultBase FINISHED_SUCCESS = new ActionResultBase(true, true);
	public static final ActionResultBase UNFINISHED_FAILURE = new ActionResultBase(false, false);
	public static final ActionResultBase UNFINISHED_BUT_CAN_PROCEED = new ActionResultBase(false, true);

	private boolean finished = false;
	private boolean success = false;

	/*** A default ActionResult instance, finished == false */
	public ActionResultBase() {
	}

	public ActionResultBase(boolean isFinished) {
		this.finished = isFinished;
	}

	public ActionResultBase(boolean isFinished, boolean success) {
		this.finished = isFinished;
		this.success = success;
	}

	@Override
	public boolean isFinished() {
		return finished;
	}

	@Override
	public int getPercentageCompleted() {
		return finished ? 100 : 0;
	}

	@Override
	public boolean isSuccess() {
		return success;
	}

}
