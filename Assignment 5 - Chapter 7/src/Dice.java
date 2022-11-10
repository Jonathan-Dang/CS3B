//Author: Jonathan Dang
//Assignment 5 | Chapter 7
import java.util.Random;

public class Dice {
	public static void main(String[] arg)
	{
		int values[] = new int[20];
		Random rand = new Random();
		
		for(int i = 0; i < 20; i++)
		{
			values[i] = rand.nextInt(6) + 1;
		}
		printDiceRolls(values);
	}
	
	/**
	 * Given a full array, it will print out the array with a marker with the longest run of a singular integer.
	 * @param array
	 */
	public static void printDiceRolls(int a[])
	{
		//Finding Longest Length
		int grab = a[0];
		int currentLength = 1;
		int longestLength = 1;

		for (int i = 1; i < a.length; i++)
		{
		    if (a[i] == grab)
		        currentLength++;
		    else
		        currentLength = 1;

		    grab = a[i];

		    if (currentLength > longestLength)
		        longestLength = currentLength;
		}
		
		//Finding Position and String manipulation
		String printMe = "";
		boolean breakpoint = true;
		
		for(int i = 0; i < a.length; i++)
		{
			int val = a[i];
			
			if(breakpoint && val == a[i + longestLength - 1])
			{
				boolean checker = true;
				for(int j = i; j < i + longestLength - 1; j++)
				{
					if(val != a[j])
					{
						checker = false;
						break;
					}
				}
				
				if(checker)
				{
					printMe += "( ";
					for(int j = 0; j < longestLength;j++)
					{
						printMe += val + " ";
					}
					printMe += ") ";
					i += longestLength - 1;
					breakpoint = false;
				}
			}
			else
				printMe += a[i] + " ";
		}
		
		//Printing
		System.out.println(printMe);
	}
}
/*
1 4 2 4 3 2 2 5 1 4 ( 5 5 5 ) 1 1 6 1 1 2 
*/