package info.agentviolet.view;

import info.agentviolet.model.IWorld;

public interface IPresentationContext {

	Object getGraphicContext();
	
	void setGraphicContext(Object g);

	void draw(IWorld world);

}
