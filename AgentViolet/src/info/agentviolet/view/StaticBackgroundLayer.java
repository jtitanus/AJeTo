package info.agentviolet.view;

public class StaticBackgroundLayer extends ViewLayerBase {

	public StaticBackgroundLayer(IViewLayerPresentationContext presentationContext) {
		super(presentationContext);
	}
	
	@Override
	public boolean isStatic() {
		return true;
	}
}
