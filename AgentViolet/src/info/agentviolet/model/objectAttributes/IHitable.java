package info.agentviolet.model.objectAttributes;

public interface IHitable {
	
	boolean isDestroyable();
	
	int getHitpoints();
	
	int getMaxHitpoints();
	
	void hit(int damage);
}
