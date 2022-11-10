//Author: Jonathan Dang
//Project: Assignment 4: Chapters 4, 5, 6
import java.util.Scanner;

public class Puzzel1089 {
	public static void main(String[] arg)
	{
		System.out.println("================================SYSTEM START=================================");
		System.out.println("Input any 3 digit number:");
		Scanner ins = new Scanner(System.in);
		int userInput = ins.nextInt();
		
		if(userInput < 100)
		{
			System.out.println("Sorry, that is not a 3 digit number.");
			System.out.println("================================SYSTEM END===================================");
			ins.close();
			System.exit(1);
		}
		
		int reversed = reverse(userInput);
		int diff = reversed - userInput;
		int diffReversed = reverse(diff);
		int sum = diff + diffReversed;
		
		System.out.println("Initial Number: " + userInput);
		System.out.println("Reversed: " + reversed);
		System.out.println("Difference: " + diff);
		System.out.println("Reversed Difference: " + diffReversed);
		System.out.println("Sum: " + sum + " <==== This should be 1089 or -1089");
		System.out.println("================================SYSTEM END===================================");
		ins.close();
	}
	
	/**
	 * Takes in a 3 digit number and reverses it
	 * @param any 3 digit integer
	 * @return the reversed of the integer
	 */
	public static int reverse(int input)
	{
		int temp = input, rev = 0;
		
		while(temp != 0)
		{
			int rem = temp % 10;
			rev = rev * 10 + rem;
			temp /= 10;
		}
		
		return rev;
	}
}

/*

================================SYSTEM START=================================
Input any 3 digit number:
521
Initial Number: 521
Reversed: 125
Difference: -396
Reversed Difference: -693
Sum: -1089 <==== This should be 1089 or -1089
================================SYSTEM END===================================

================================SYSTEM START=================================
Input any 3 digit number:
1
Sorry, that is not a 3 digit number.
================================SYSTEM END===================================
*/