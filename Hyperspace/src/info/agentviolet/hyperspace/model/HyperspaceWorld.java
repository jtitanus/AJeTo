package info.agentviolet.hyperspace.model;

import java.util.ArrayList;
import java.util.List;

import info.agentviolet.impl.WorldBase;
import info.agentviolet.view.IViewLayer;

public class HyperspaceWorld extends WorldBase {

	public HyperspaceWorld() {
		super();
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	protected List<IViewLayer> initViewLayers() {
		return new ArrayList<IViewLayer>(3);
	}
}
