package assignment6JD;
//Author: Jonathan Dang
//Project: Chapter 8 - PP8.1
/**
 * Combination Lock Object used in PP8.1
 * @author Jonathan Dang
 *
 */
public class ComboLock {
	private int firstNum, secondNum, thirdNum;
	private int attempt1, attempt2, attempt3;
	private boolean turn1, turn2, turn3;
	
	/**
	 * Constructs a ComboLock with given Combination Unlock Codes
	 * @param secret1
	 * @param secret2
	 * @param secret3
	 */
	public ComboLock(int secret1, int secret2, int secret3)
	{
		firstNum = secret1;
		secondNum = secret2;
		thirdNum = secret3;
		attempt1 = -1;
		attempt2 = -1;
		attempt3 = -1;
		turn1 = false;
		turn2 = false;
		turn3 = false;
	}
	
	/**
	 * Resets the attempts and allows for retries after.
	 */
	public void reset()
	{
		attempt1 = -1;
		attempt2 = -1;
		attempt3 = -1;
		
		turn1 = false;
		turn2 = false;
		turn3 = false;
	}
	
	/**
	 * Turns the virtual Dial counter-clock wise to attempt to input an entry
	 * @param ticks
	 */
	public void turnLeft(int ticks)
	{
		 if(attempt2 == -1 && attempt1 != -1)
		 {
			 attempt2 = ticks;
			 turn2 = true;
		 }
		 else
		 {
			 if(attempt1 == -1)
				 attempt1 = ticks;
			 else if(attempt2 == -1)
				 attempt2 = ticks;
			 else
				 attempt3 = ticks;
		 }
	}
	
	/**
	 * Turns the virtual Dial clock wise to attempt to input an entry
	 * @param ticks
	 */
	public void turnRight(int ticks)
	{
		if(attempt1 == -1)
		{
			attempt1 = ticks;
			turn1 = true;
		}
		else if(attempt1 != -1 && attempt2 != -1 && attempt3 == -1)
		{
			attempt3 = ticks;
			turn3 = true;
		}
		else
		{
			if(attempt2 == -1)
				attempt2 = ticks;
			else
				attempt3 = ticks;
		}
	}
	
	/**
	 * Determines whether or not the series of inputs are valid
	 * @return true if all inputs are valid
	 */
	public boolean open()
	{
		 return (attempt1 == firstNum && attempt2 == secondNum && attempt3 == thirdNum) && (turn1 && turn2 && turn3);
	}
}
