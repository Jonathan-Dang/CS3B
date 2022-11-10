package PP13_8;

/**
 * Coordinate Holds a position in any grid system.
 * @author Jonathan Dang || Zaojia Zhao
 * NOTE: This takes concepts from the Linked-List as it has a parent node associated with this one
 */
public class Coordinate {
	private int _x;
	private int _y;
	private Coordinate _parent;
	
	/**
	 * Constructs a Coordinate
	 * @param x The X-Coord
	 * @param y The Y-Coord
	 */
	public Coordinate(int x, int y)
	{
		_x = x;
		_y = y;
	}
	
	/**
	 * Constructs a Coordinate while saving the previous Coordinate that lead to this one
	 * @param x The X-Coord
	 * @param y The Y-Coord
	 * @param parent The Previous Coordinate
	 */
	public Coordinate(int x, int y, Coordinate parent)
	{
		_x = x;
		_y = y;
		this._parent = parent;
	}
	
	/**
	 * Returns the X Coordinate
	 * @return x 
	 */
	public int getXCoord()
	{
		return _x;
	}
	
	/**
	 * Returns the Y Coordinate
	 * @return y
	 */
	public int getYCoord()
	{
		return _y;
	}
	
	/**
	 * Returns the previous Coordinate
	 * @return parent
	 */
	public Coordinate getParent()
	{
		return this._parent;
	}
	
	/**
	 * Checks if the Coordinate given has the same coordinates as this.
	 * @param right Coordinate
	 * @return True if x and y are the same
	 */
	public boolean equals(Coordinate right)
	{
		return _x == right.getXCoord() && _y == right.getYCoord();
	}
}
