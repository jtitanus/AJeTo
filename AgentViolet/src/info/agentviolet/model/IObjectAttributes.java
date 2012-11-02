package info.agentviolet.model;

/***
 * 
 * Defines an extensible storage of world object attributes.
 *
 */
public interface IObjectAttributes {

	/***
	 * Integer index of the attribute. Should be used with defined public static final int values.
	 * Chosen because of better extensibility (an enum cannot extend another enum).
	 * More specific object attribute definitions should extend the ObjectAttributesBase class in order
	 * to have access to all derived attributes.
	 *   
	 * @param attribute integer index of attribute
	 * @return
	 */
	Object getAttribute(int attribute);
	
	void setAttribute(int attribute, Object value);
}
