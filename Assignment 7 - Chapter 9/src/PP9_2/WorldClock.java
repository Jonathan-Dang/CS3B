//Author: Jonathan Dang
//Project: PP9.2
package PP9_2;

/**
 * SubClass World Clock Object
 * @author pocke
 *
 */
public class WorldClock extends Clock
{
	private int offset;
	/**
	 * Constructs a WorldClock object and holds an hour offset
	 * @param off
	 */
	public WorldClock(int off)
	{
		super();
		offset = off;
	}
	
	/**
	 * Override getHours
	 * @returns offset Hours
	 */
	public String getHours()
	{
		int current = Integer.parseInt(super.getHours());
		int offSetTime = current + offset;
		return String.valueOf(offSetTime);
	}
}
