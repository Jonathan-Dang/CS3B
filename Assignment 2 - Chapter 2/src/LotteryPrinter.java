//Author: Dang, Jonathan
//Project: Lottery Printer | Project 2.7
import java.util.Scanner;
import java.util.Random;
public class LotteryPrinter {
	public static void main(String[] arg)
	{
		System.out.println("===============Program Start===============");
		//Declarations
		int userNum[] = new int[6];
		int lottoNums[] = new int[6];
		Scanner input = new Scanner(System.in);
		
		//Obtain User Input
		for(int i = 0; i < 6;i++)
		{
			System.out.print("Please Enter a Number from 1-49 for position " + (i+1) + ": ");
			userNum[i] = input.nextInt();
		}
		
		//Function to obtain random data set
		lottoNums = randomNumbers(49,6);
		
		//Revealing Data set for matching pairs
		System.out.println("You punched in these numbers onto your Lotto Card:");
		arrayScanner(userNum,6);
		System.out.println("You tune into the nearest Lotto station and he announces,");
		System.out.println("\"HELLO LISTENERS! It's your Radio Show Host, Markus Moneybags! Now to the main event,"
				+ "Today's Lotto numbers are...\"");
		arrayScanner(lottoNums,6);
		
		//System Close
		input.close();
		System.out.println("===============End of Program===============");
		return;
	}
	
	public static void arrayScanner(int A[],int size)
	{
		for(int i = 0; i < size; i ++)
		{
			System.out.print(A[i]);
			if(i != size-1) {System.out.print(", ");}
		}
		System.out.println();
	}
	
	public static int[] randomNumbers(int upB, int size)
	{
		int rand[] = new int[size];
		Random gen = new Random();
		for(int i = 0; i < size; i++)
		{
			int temp = gen.nextInt(upB);
			if(temp == 0) {temp++;}
			rand[i] = temp;
		}
		return rand;
	}
}

//Sample Run
/*
===============Program Start===============
Please Enter a Number from 1-49 for position 1: 34
Please Enter a Number from 1-49 for position 2: 17
Please Enter a Number from 1-49 for position 3: 3
Please Enter a Number from 1-49 for position 4: 46
Please Enter a Number from 1-49 for position 5: 5
Please Enter a Number from 1-49 for position 6: 29
You punched in these numbers onto your Lotto Card:
34, 17, 3, 46, 5, 29
You tune into the nearest Lotto station and he announces,
"HELLO LISTENERS! It's your Radio Show Host, Markus Moneybags! Now to the main event,Today's Lotto numbers are..."
8, 27, 23, 42, 48, 36
===============End of Program===============
*/
