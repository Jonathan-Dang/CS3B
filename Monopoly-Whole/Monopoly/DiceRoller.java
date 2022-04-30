package Monopoly;

import java.util.Random;

/**
 * The Static Function Library
 * @author Jonathan Dang
 *
 */
public class DiceRoller {
	private static Random _randomNumberGen = new Random();
	
	/**
	 * Returns 2 Dice rolls in an Array
	 * @return int[] The Dice Roll
	 */
	public static int[] getDiceRolls()
	{
		int[] rolls = new int[2];
		
		for(int i = 0; i < 2; i ++)
		{
			rolls[i] = _randomNumberGen.nextInt(6) + 1;
		}
		
		return rolls;
	}
	
	/**
	 * Returns the total Roll of the Dice
	 * @return int The Total Dice ROll
	 */
	public static int rollDice()
	{
		int rolls[] = getDiceRolls();
		int total = 0;
		for(int i = 0; i < 2; i++)
		{
			total += rolls[i];
		}
		return total;
	}
}
