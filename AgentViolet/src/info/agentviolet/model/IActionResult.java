package info.agentviolet.model;

public interface IActionResult {
	
	boolean isFinished();
	
	int getPercentageCompleted();
	
	boolean isSuccess();
}
