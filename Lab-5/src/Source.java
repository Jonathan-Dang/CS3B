import java.util.ArrayList;
import java.util.Scanner;

//Author: Jonathan Dang
//Lab 5 | 7.14
public class Source {
	public static void main(String[] args)
	{
		Scanner ins = new Scanner(System.in);
		Store store = new Store();
		
		System.out.println("To enter in a Customer, First input the price then the name, marking the end of the price of 0");
		
		while(true)
		{
			System.out.println("Please input a price: ");
			double p = ins.nextDouble();
			if(p == 0)
				break;
			System.out.println("Please input a name: ");
			String n = ins.next();
			store.addSale(n, p);
		}
		
		System.out.println("Now input the amount of customers you want to see in the highest spenders: ");
		int topN = ins.nextInt();
		
		System.out.println("The top " + topN + " Customers at this store are: ");
		ArrayList<String> bestCustomers = store.nameOfTheBestCustomer(topN);
		for(int i = 0; i < bestCustomers.size(); i++)
		{
			System.out.println("Number " + (i+1) + " " + bestCustomers.get(i));
		}
		ins.close();
	}
}
/*
=========================topN < .size()========================
To enter in a Customer, First input the price then the name, marking the end of the price of 0
Please input a price: 
100
Please input a name: 
John
Please input a price: 
10
Please input a name: 
Sam
Please input a price: 
0
Now input the amount of customers you want to see in the highest spenders: 
1
The top 1 Customers at this store are: 
John
=========================topN == .size()=======================
To enter in a Customer, First input the price then the name, marking the end of the price of 0
Please input a price: 
100
Please input a name: 
John
Please input a price: 
10
Please input a name: 
Sam
Please input a price: 
0
Now input the amount of customers you want to see in the highest spenders: 
2
The top 2 Customers at this store are: 
1 John
2 Sam
*/