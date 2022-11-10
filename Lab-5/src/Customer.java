//Authors: Jonathan Dang
//Lab 5 | 7.14
/**
 * A Fundamental Customer Class that stores their highest sale and their name
 * @author Jonathan
 *
 */
public class Customer {
	private String name;
	private double saleMoney;
	
	/**
	 * Constructs an Empty Customer Object
	 */
	public Customer()
	{
		name = "";
		saleMoney = 0;
	}
	
	/**
	 * Constructs a Customer object given the parameters
	 * @param name
	 * @param Sale Amount
	 */
	public Customer(String n, double sM)
	{
		name = n;
		saleMoney = sM;
	}
	
	/**
	 * Returns the name of the Customer
	 * @return Name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the Sale Amount the customer had
	 * @return Sale Amount
	 */
	public double getSale()
	{
		return saleMoney;
	}
}
