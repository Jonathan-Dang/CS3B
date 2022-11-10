import java.util.ArrayList;

//Authors: Jonathan Dang
//Lab 5 | 7.14
/**
 * A Store object meant to output the best Customers' name
 * This was modified from Project 7.13 to account for 7.14's problem
 * @author Jonathan
 *
 */
public class Store {
	private ArrayList<Customer> Customers;
	
	/**
	 * Creates an Empty Store Object
	 */
	public Store()
	{
		Customers = new ArrayList<Customer>();
	}
	
	/**
	 * Adds the Customer to the store's records and records the amount they spent
	 * @param customer's Name
	 * @param amount they spent
	 */
	public void addSale(String customerName, double amount)
	{
		Customers.add(new Customer(customerName, amount));
	}
	
	/**
	 * This functions gives the user a list of names of the Biggest spenders within the store records
	 * @param Top Number
	 * @return List of Names
	 */
	public ArrayList<String> nameOfTheBestCustomer(int topN)
	{
		ArrayList<String> bestCustomers = new ArrayList<String>();
		sortCustomers();
		
		if(Customers.size() <= topN)
		{
			for(int i = Customers.size()-1; i >= 0;i--)
			{
				bestCustomers.add(Customers.get(i).getName());
			}
		}
		else
		{
			for(int i = Customers.size(); i >= topN;i--)
			{
				bestCustomers.add(Customers.get(i-1).getName());
			}
		}
		
		return bestCustomers;
	}
	
	/**
	 * Sorts the stored records by smallest amount to largest amount
	 */
	private void sortCustomers()
	{
		int min = 0;
		
		for(int i = 0; i < Customers.size(); i++)
		{
			min = i;
			for(int j = i + 1; j < Customers.size(); j++)
			{
				if(Customers.get(j).getSale() < Customers.get(min).getSale())
					min = j;
			}
			Customer temp = Customers.get(i);
			Customers.set(i, Customers.get(min));
			Customers.set(min, temp);
		}
	}
}
