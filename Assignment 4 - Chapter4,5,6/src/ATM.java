//Author: Jonathan Dang
//Project: Assignment 4: Chapters 4, 5, 6
import java.util.Scanner;

public class ATM {
	public static void main(String[] arg)
	{
		System.out.println("================================SYSTEM START=================================");
		int attempts = 3;
		Scanner ins = new Scanner(System.in);
		while(attempts != 0)
		{
			System.out.print("Please enter your Pin: ");
			int userPin = ins.nextInt();
			if(userPin != 1234)
			{
				System.out.println("Your Pin is Incorrect | " + --attempts + " Remaining");
			}
			else
			{
				System.out.println("Your Pin is Correct!");
				System.out.println("================================SYSTEM END===================================");
				ins.close();
				System.exit(0);
			}
		}
		
		System.out.println("Your Bank Card is Blocked!");
		ins.close();
		System.out.println("================================SYSTEM END===================================");
	}
}
/*
Entering a pin correctly
================================SYSTEM START=================================
Please enter your Pin: 1234
Your Pin is Correct!
================================SYSTEM END===================================

Entering a pin incorrectly and failing
================================SYSTEM START=================================
Please enter your Pin: 1
Your Pin is Incorrect | 2 Remaining
Please enter your Pin: 2
Your Pin is Incorrect | 1 Remaining
Please enter your Pin: 3
Your Pin is Incorrect | 0 Remaining
Your Bank Card is Blocked!
================================SYSTEM END===================================

*/