//Author: Jonathan Dang
//Project: Assignment 4: Chapters 4, 5, 6
import java.util.Scanner;

public class MeanAndSD {
	public static void main(String[] arg)
	{
		System.out.println("================================SYSTEM START=================================");
		DataSet d = new DataSet();
		Scanner ins = new Scanner(System.in);
		String cancel;
		
		System.out.println("Enter any Number to add to the data set by typing in a number"
				+ " and pressing the Enter key. If you want to exit, Enter X instead: ");
		while(true)
		{
			cancel = ins.next();
			if(cancel.contains("x") || cancel.contains("X"))
				break;
			d.add(Double.parseDouble(cancel));
		}
		
		System.out.print("Set: ");
		printArray(d.getSet(),d.getCount());
		System.out.println("Entries: " + d.getCount());
		System.out.println("Sum: " + d.getSum());
		System.out.println("Average | Mean: " + d.getAverage());
		System.out.println("Unstable Standard Deviation: " + d.getUnstableStandardDeviation());
		System.out.println("Standard Deviation: " + d.getStandardDeviation());
		System.out.println("Margin of Error: " + d.getMarginOfError());
		System.out.println("Variance: " + d.getVariance());
		
		ins.close();
		System.out.println("================================SYSTEM END===================================");
	}
	
	public static void printArray(double[] d, double size)
	{
		for(int i = 0; i < size;i++)
		{
			System.out.print(d[i] + " ");
		}
		System.out.println();
	}
}
/*
================================SYSTEM START=================================
Enter any Number to add to the data set by typing in a number and pressing the Enter key. If you want to exit, Enter X instead: 
1 2 3 4 5 6 7 8 9 x
Set: 1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0 
Entries: 9.0
Sum: 45.0
Average | Mean: 5.0
Unstable Standard Deviation: 2.545048668939894
Standard Deviation: 2.581988897471611
Margin of Error: 0.8606629658238704
Variance: 6.666666666666666
================================SYSTEM END===================================
*/
