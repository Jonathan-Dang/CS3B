package lab6.JonathanDang;

import java.util.Random;

/**
 * A Passenger is an object with only one goal,
 * To be transported to a desired station.
 * @author Jonathan Dang
 *
 */
public class Passenger {
	private int destination;
	private static final int DEFAULT_MAX_STATIONS = 30;
	
	/**
	 * Default Constructor
	 */
	public Passenger()
	{
		Random rand = new Random();
		destination = rand.nextInt(DEFAULT_MAX_STATIONS) + 1;
	}
	
	/**
	 * Sets the newly constructed passenger's destination to the given number
	 * @param destination
	 */
	public Passenger(int dest)
	{
		destination = dest;
	}
	
	/**
	 * Returns the passenger's Destination
	 * @returns destination
	 */
	public int getDest()
	{
		return destination;
	}
}
