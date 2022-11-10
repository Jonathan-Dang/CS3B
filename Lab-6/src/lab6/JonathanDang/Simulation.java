package lab6.JonathanDang;

import java.util.ArrayList;

public class Simulation {
	public static void main(String[] arg)
	{
		System.out.println("Doing the Car Simulation 1000 times, the average revenue per mile is: " 
				+ String.format("%.2f",averageSimulation()));
		System.out.println("This is for a random amount of Passengers that goes up to 102 but atleast has 3 per station.");
	}
	
	private static double averageSimulation()
	{
		double totalMoney = 0;
		for(int z = 0; z < 1000; z ++)
		{
			/*
			 * I need some way of using the car's Move function in order to get rid
			 * of some passengers in order to maximize 8.4's capabilities.
			 */
			ArrayList<Station> sim = new ArrayList<Station>();
			for(int i = 0; i < 30; i ++)
			{
				sim.add(new Station());
			}
			/*
			 * I am thinking that maybe I should use a 2D list in order to obtain all of the cars traveling and individually
			 * tick their move function. If the system detects if a certain car drops off a passenger, it picks
			 * another up at the current station.
			 */
			ArrayList<ArrayList<Car>> allCars = new ArrayList<ArrayList<Car>>();
			for(int i = 0; i < 30; i ++)
			{
				allCars.add(sim.get(i).getCars());
			}
			
			double Cars = 0;
			for(int i = 0; i < allCars.size();i++)
			{
				Cars += allCars.get(i).size();
			}
			Cars = Cars / allCars.size();
			
			/*
			 * I also need a way to know whether or not all the cars are active or not.
			 * Really the only way to know is if their move function turns false.
			 * However, its really tedious to keep on checking for the false.
			 * My solution is just delete the car entirely from the list if it reaches its destination.
			 * This includes the lists in which no more cars remain.
			 * We also need to count the miles driven before we delete the car itself.
			 * Adding an extra line for counting would do it.
			 */
			double miles = 0;
			while(allCars.size() > 1)
			{
				for(int i = 0; i < allCars.size(); i++)
				{
					for(int t = 0; t < allCars.get(i).size(); t ++)
					{
						if(!allCars.get(i).get(t).move())
						{
							miles += allCars.get(i).get(t).getTotalMilesDriven();
							allCars.get(i).remove(t);
							break;
						}
						if(allCars.get(i).get(t).dropOff())
						{
							int pos = allCars.get(i).get(t).getPosition();
							sim.get(pos - 1).refillCar(allCars.get(i).get(t));
						}
					}
					
					if(allCars.get(i).size() == 0)
					{
						allCars.remove(i);
						break;
					}
				}
			}
			
			totalMoney += miles / Cars;
		}//1000 loops
		return totalMoney/1000;
	}
}
/*
 * Doing the Car Simulation 1000 times, the average revenue per mile is: 400817.64
 * This is for a random amount of Passengers that goes up to 102 but atleast has 3 per station.
 */
