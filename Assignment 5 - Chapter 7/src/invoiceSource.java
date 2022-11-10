//Author: Jonathan Dang
//Assignment 5 | Chapter 7
import java.util.Scanner;

public class invoiceSource {
	public static void main(String[] args)
	{
		Scanner ins = new Scanner(System.in);
		Invoice invoice = new Invoice();
		
		System.out.println("Entry of items comes in three stages, first the price, then the quantity, then if it is a pet or not.");
		System.out.println("If you want to end the entries, then please put the price as -1.");
		while(true)
		{
			System.out.println("Please Enter the Price:");
			double price = ins.nextDouble();
			if(price == -1)
				break;
			System.out.println("Please Enter the Quantity:");
			int quantity = ins.nextInt();
			System.out.println("Please Enter Y for a pet and N for no :");
			String entry = ins.next();
			boolean pet = false;
			if(entry.equals("Y"))
				pet = true;
			
			invoice.add(new Item(price,pet,quantity));
		}
		
		System.out.println("Subtotal: " + invoice.getDiscount());
		ins.close();
	}
}
/*
Entry of items comes in three stages, first the price, then the quantity, then if it is a pet or not.
If you want to end the entries, then please put the price as -1.
Please Enter the Price:
10
Please Enter the Quantity:
23
Please Enter Y for a pet and N for no :
N
Please Enter the Price:
15
Please Enter the Quantity:
1
Please Enter Y for a pet and N for no :
Y
Please Enter the Price:
-1
Subtotal: 196.0

*/