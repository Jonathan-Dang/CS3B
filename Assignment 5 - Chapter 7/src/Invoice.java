//Author: Jonathan Dang
//Assignment 5 | Chapter 7
import java.util.ArrayList;

/**
 * The Invoice class
 * @author Jonathan Dang
 *
 */
public class Invoice {
	private ArrayList<Item> invoice;
	
	/**
	 * Creates an empty Invoice
	 */
	public Invoice()
	{
		invoice = new ArrayList<Item>();
	}
	
	/**
	 * Adds a given item
	 * @param item
	 */
	public void add(Item item)
	{
		invoice.add(item);
	}
	
	/**
	 * Calculates the subtotal for the Invoice as well as calculate the discount
	 * @returns grand total
	 */
	public double getDiscount()
	{
		double discounted = 0;
		for(int i = 0; i < invoice.size(); i ++)
		{
			double price = (double) invoice.get(i).getPrice() * (double) invoice.get(i).getQuantity();
			if(!invoice.get(i).isPet())
				price -= price * 0.2; 
			discounted += price;
		}
		return discounted;
	}
}
