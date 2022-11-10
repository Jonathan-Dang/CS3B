package lab6.JonathanDang;

import java.util.ArrayList;

/**
 * A Car should be able to pick up passengers and drop them off
 * They should also keep track with how much they are making.
 * Cars only go in One Direction, pick up passengers and drop them off
 * 		along the way.
 * @author Jonathan Dang
 *
 */
public class Car {
	private ArrayList<Passenger> inside;
	private int position;
	private int destination;
	private int payMiles;
	private static final int MAX = 3;
	
	/**
	 * Constructs a Car and tells it where it is and where it is going
	 * @param pos
	 * @param dest
	 */
	public Car(int pos, int dest)
	{
		inside = new ArrayList<Passenger>();
		position = pos;
		destination = dest;
		payMiles = 0;
	}
	
	/**
	 * Drops off any number of people at the current destination if they want to.
	 * @return false if no one is in the car
	 */
	public boolean dropOff()
	{
		ArrayList<Integer> people = new ArrayList<Integer>();
		for(int i = 0; i < inside.size() - 1; i++)
		{
			if(inside.get(i).getDest() == position)
			{
				people.add(i);
			}
		}
		
		if(!people.isEmpty())
		{
			for(int i = 0; i < people.size();i++)
			{
				inside.remove((int)people.get(i));
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Picks up a Passenger
	 * @param p
	 * @return true if successfully picks up the passenger
	 */
	public boolean pickUp(Passenger p)
	{
		if(inside.size() >= MAX)
			return false;
		else
			return inside.add(p);
	}
	
	public int getDest()
	{
		return destination;
	}
	
	/**
	 * Moves the car in the direction of it's destination
	 * @return false if it is at its destination
	 */
	public boolean move()
	{	
		if(position > destination)
		{
			position--;
			for(int i = 0; i < inside.size();i++)
			{
				payMiles++;
			}
			return true;
		}
		else if(position < destination)
		{
			position++;
			for(int i = 0; i < inside.size();i++)
			{
				payMiles++;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the total miles gained from it's trip
	 * @return payMiles
	 */
	public int getTotalMilesDriven()
	{
		return payMiles;
	}
	
	/**
	 * Returns the current amount of people within the car
	 * @return amount of people
	 */
	public int getInside()
	{
		return inside.size();
	}
	
	/**
	 * Returns the current position
	 * @return pos
	 */
	public int getPosition()
	{
		return position;
	}
}
