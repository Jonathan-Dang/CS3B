package Monopoly;

/**
 * Abstract Space Object
 * @author Jonathan Dang
 *
 */
public abstract class Spaces {
	private String _name;
	
	/**
	 * Constructs an abstract Space
	 * @param n The Name
	 */
	public Spaces(String n)
	{
		this._name = n;
	}
	
	/**
	 * Returns the Name of the Space
	 * @return String theName
	 */
	public String getName()
	{
		return _name;
	}
	
	public abstract void activateSpace(player p, Board b);
	
	public abstract int getOwnerIndex();
	
	public abstract void sellSpace(player p);
}
