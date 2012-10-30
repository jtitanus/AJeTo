package info.agentviolet.impl.basicActions;

import info.agentviolet.impl.ActionResultBase;
import info.agentviolet.model.IAction;
import info.agentviolet.model.IActionResult;
import info.agentviolet.model.IAgent;
import info.agentviolet.model.IWorldObject;
import info.agentviolet.utils.VectorUtils;

/***
 * Sets looking position to the location of the nearest world object of the
 * specified type.
 * 
 * @param <TypeToSeek>
 */
public class Seek implements IAction {

	private Class<?> typeToSeek;

	public Seek(Class<?> typeToSeek) {
		this.typeToSeek = typeToSeek;
	}

	@Override
	public IActionResult letDo(IAgent agent) {
		IActionResult res = ActionResultBase.UNFINISHED; 
		IWorldObject wo = VectorUtils.getNearestWorldObject(
				agent.getWorld().getWorldObjects(), typeToSeek, 
				agent.getLocation().getPosition());
		if (wo != null) {
			agent.getLocation().setLookingPosition(
					wo.getLocation().getPosition());
			res = ActionResultBase.FINISHED;
		} else {
			agent.getLocation().setLookingPosition(null);
		}
		return res;
	}

}
