package lab6.JonathanDang;

import java.util.ArrayList;
import java.util.Random;

/**
 * A Station keeps track of the cars it starts off with
 * as well as has a list of people on stand by to fill on comming cars
 * @author Jonathan Dang
 *
 */
public class Station {
	private static int stationNumber = 0;
	private ArrayList<Passenger> standby;
	private ArrayList<Car> taxi;
	
	/**
	 * Generates a Station with a random amount of cars and passengers
	 */
	public Station()
	{
		//Station Number
		++stationNumber;
		
		//Passenger assignment
		Random rand = new Random();
		int p = rand.nextInt(99)/3 + 3;
		standby = new ArrayList<Passenger>();
		for(int i = 0; i < p ;i++)
		{
			standby.add(new Passenger());
		}
		
		//Car assignment
		int c = rand.nextInt(p) + 1;
		int dest = rand.nextInt(30) + 1;
		taxi = new ArrayList<Car>();
		for(int i = 0; i < c; i++)
		{
			taxi.add(new Car(this.getStationNumber(),dest));
		}
		
		//Every car needs a to hit the max of 3, but only takes Passengers that is on the way to the destination.
		//We need to loop in the Passenger list so that we can fill in the Cars.
		//Car loop: 3 runs per car. If it happens that its destination is here, then just skip the car
		//Passenger loop: Until all Cars are full or is empty
		
		for(int i = 0; i < taxi.size();i++)
		{
			int slots = 0;
			while(slots < 3)
			{
				for(int t = 0; t < standby.size(); t++)
				{
					//If the passenger has a destination between here and this car's dest, pick up
					
					if(this.getStationNumber() > taxi.get(i).getDest())
					{
						if(taxi.get(i).getDest() <= standby.get(t).getDest() && 
								standby.get(t).getDest() <= this.getStationNumber())
						{
							taxi.get(i).pickUp(standby.get(t));
							standby.remove(t);
							break;
						}
					}
					else if(this.getStationNumber() < taxi.get(i).getDest())
					{
						if((this.getStationNumber() <= standby.get(t).getDest()) && 
								(standby.get(t).getDest() <= taxi.get(i).getDest()))
						{
							taxi.get(i).pickUp(standby.get(t));
							standby.remove(t);
							break;
						}
					}
					else
						break;
				}//Individual Passenger Loop
				slots++;
			}//Passenger Filler Loop
		}//Car Loop
	}
	
	/**
	 * Returns the List of cars this station is in charge of
	 * @return list of cars
	 */
	public ArrayList<Car> getCars()
	{
		return taxi;
	}
	
	/**
	 * Returns the station number
	 * @return station number
	 */
	public int getStationNumber()
	{
		return Station.stationNumber;
	}
	
	/**
	 * Refills on coming cars
	 * @param car
	 */
	public void refillCar(Car c)
	{
		if(c.getInside() == 3 || standby.size() == 0)
			return;
		
		boolean looper = true;
		int check = 0;
		
		while(looper)
		{
			for(int i = 0; i < standby.size(); i++)
			{
				if(this.getStationNumber() < c.getDest())
				{
					if((this.getStationNumber() <= standby.get(i).getDest()) && 
							(standby.get(i).getDest() <= c.getDest()))
					{
						if(!c.pickUp(standby.get(i)))
							looper = false;
						standby.remove(i);
						break;
					}
				}
				else if(this.getStationNumber() > c.getDest())
				{
					if(c.getDest() <= standby.get(i).getDest() && 
							standby.get(i).getDest() <= this.getStationNumber())
					{
						if(!c.pickUp(standby.get(i)))
							looper = false;
						standby.remove(i);
						break;
					}
				}
				
				if(c.getInside() < 3 && i == standby.size() - 1)
				{
					looper = false;
				}
			}
			
			check++;
			if(check < 4)
				break;
		}
	}
}
