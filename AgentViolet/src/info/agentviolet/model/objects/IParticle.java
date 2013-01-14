package info.agentviolet.model.objects;


public interface IParticle {

	void update();
	
	int getIndex();
	void setIndex(int index);
	
	float getX();
	float getY();
	float getXVel();
	float getYVel();
	
	void setX(float x);
	void setY(float y);
	void setXVel(float velX);
	void setYVel(float velY);
	
}
