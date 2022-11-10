//Author: Jonathan Dang
//Assignment 5 | Chapter 7
/**
 * Basic Item Class
 * @author Jonathan Dang
 *
 */
public class Item {
	private double _price;
	private boolean _isPet;
	private int _quantity;
	
	/**
	 * Constructs an Item with parameters
	 * @param price
	 * @param isPet
	 * @param quantity
	 */
	public Item(double price, boolean isPet, int quantity)
	{
		_price = price;
		_isPet = isPet;
		_quantity = quantity;
	}
	
	/**
	 * Returns a price
	 * @returns the price
	 */
	public double getPrice()
	{
		return _price;
	}
	
	/**
	 * Returns if its a pet or not
	 * @return true = pet, false = not pet
	 */
	public boolean isPet()
	{
		return _isPet;
	}
	
	/**
	 * Returns the quantity of the item
	 * @returns the quantity
	 */
	public int getQuantity()
	{
		return _quantity;
	}
}
