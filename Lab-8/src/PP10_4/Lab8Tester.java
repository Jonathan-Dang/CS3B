//Author: Jonathan Dang
//Project: PP10.4
package PP10_4;

import java.util.ArrayList;
import java.util.Random;

public class Lab8Tester {
	public static void main(String[] args)
	{
		System.out.println("================================START==================================");
		BankAccountMeasurer BAM = new BankAccountMeasurer();
		BankAccountFilter BAF = new BankAccountFilter(1000);
		ArrayList<BankAccount> ABA = new ArrayList<BankAccount>();
		Random rand = new Random();
		
		for(int i = 0; i < 1000; i++)
			ABA.add(new BankAccount((double)rand.nextInt(10000)));
		
		double averageBalance = Data.average(ABA.toArray(), BAM, BAF);
		System.out.println("Average Balance: " + averageBalance);
		System.out.println("=================================END==================================");
	}
}
