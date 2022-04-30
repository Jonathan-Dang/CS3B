package Monopoly_Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Monopoly.Board;
import Monopoly.Spaces;
import Monopoly.player;

/**
 * The Property Space
 * @author Jonathan Dang
 *
 */
public class Property extends Spaces{
	private int _cost; //Base Cost	
	private int _rent; //Base Rent
	private int _houses; //Only up to 4 houses.
	private int _houseRent1;
	private int _houseRent2;
	private int _houseRent3;
	private int _houseRent4;
	private int _buildingCost; //Cost per building
	private boolean _hotel; //Only 1 hotel. true if player has bought hotel
	private int _hotelRent; //Rent if Hotel is purchased [Must Have 4 Houses] {sets houses to 0}
	private int _ownerIndex = -1; //This is the index of the owner, 0->3
	
	//I need a way to implement selling properties,
	//SOLUTION 1: Put an abstract function onto the Space File and make it return owner index on only property spaces
	//SOLUTION 2: Put an abstract function onto each Property File and make it sell for half price flat.
	
	//For Solution 1, when I make the sell method, I would run through the entire _board calling the abstract method to return the owner's Index
	//as it will give me a list of the names to display. As for the selling part, each one will have their own selling but generally will be
	//standardized between all types of properties.
	
	//I am not too sure for Solution 2, so I will proceed on Solution 1 currently. 5/31/2021
	
	/**
	 * Constructs a Property
	 * @param name The Name
	 * @param price The Price
	 * @param rent The Initial Rent
	 * @param HouseRent1 Rent at 1 house
	 * @param HouseRent2 Rent at 2 Houses
	 * @param HouseRent3 Rent at 3 Houses
	 * @param HouseRent4 Rent at 4 Houses
	 * @param hotelRent Rent at Hotel Level
	 * @param buildingCost The Building Cost
	 */
	public Property(String name, int price, int rent, int HouseRent1,
			int HouseRent2, int HouseRent3, int HouseRent4, int hotelRent, int buildingCost) {
		super(name);		
		_cost = price;
		_rent = rent;
		_houseRent1 = HouseRent1;
		_houseRent2 = HouseRent2;
		_houseRent3 = HouseRent3;
		_houseRent4 = HouseRent4;
		_hotelRent = hotelRent;
		_buildingCost = buildingCost;
	}
	
	/**
	 * Attempts to buy a certain amount of houses
	 * @param p The Player
	 * @param amount Amount of houses
	 * @return True if successfully buys a house
	 */
	public boolean buyHouse(player p, int amount)
	{
		if (amount + _houses >= 4)
		{
			int fillHouses = amount - _houses;
			if (p.getBalance() < fillHouses * _buildingCost)
			{
				//This person cannot buy this much, I will choose to just refuse the entire thing.
				return false;
			}
			else
			{
				int costs = fillHouses * _buildingCost;
				_houses = 4;
				p.manipulateMoney(-costs);
				return true;
			}
		}
		else
		{
			
			if (p.getBalance() < amount * _buildingCost)
			{
				//This person cannot buy this much, I will choose to just refuse the entire thing.
				return false;
			}
			else
			{
				int costs = amount * _buildingCost;
				_houses += amount;
				p.manipulateMoney(-costs);
				return true;
			}
		}
	}
	
	/**
	 * Attempts to buy a Hotel
	 * @param p The Player
	 * @return True if successfully buys a house
	 */
	public boolean buyHotel(player p)
	{
		if (p.getBalance() >= _buildingCost && this.getHouse() == 4)
		{
			_hotel = true;
			p.manipulateMoney(-_buildingCost);
			this._houses = 0;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Returns the Building Cost
	 * @return int The Building Cost
	 */
	public int getBuildingCost()
	{
		return _buildingCost;
	}
	
	/**
	 * Returns the amount of houses on this property
	 * @return int the houses
	 */
	public int getHouse()
	{
		return _houses;
	}
	
	/**
	 * Returns if there is a hotel
	 * @return boolean The Hotel
	 */
	public boolean getHotel()
	{
		return _hotel;
	}

	@Override
	public void activateSpace(player p, Board b) {
		JFrame jf = new JFrame();
		if (_ownerIndex < 0) //No one owns this
		{
			int option = JOptionPane.showConfirmDialog(jf,"PLAYER " + ((int)p.getIndex() + 1) + ": Buy " + this.getName() +"?");
			if (option == JOptionPane.YES_OPTION)
			{
				if (p.getBalance() < this._cost)
				{
					JOptionPane.showMessageDialog(jf,"PLAYER " + ((int)p.getIndex() + 1) + 
							": You don't have enought money!","Alert",JOptionPane.WARNING_MESSAGE);  
					return;
				}
				p.manipulateMoney(-_cost);
				_ownerIndex = p.getIndex();
				
				JOptionPane.showMessageDialog(jf,"PLAYER " + ((int)p.getIndex() + 1) + ": You spent $" + this._cost + " on buying " + this.getName() + "!");
			}
			else
				return;
		}
		else //a play at this index owns this
		{
			if (_ownerIndex != p.getIndex()) //pay rent!
			{
				int rent = this._rent;
				if (_hotel)
					rent = _hotelRent;
				else
				{
					switch(this.getHouse())
					{
					case(0):
						rent = this._rent;
						break;
					case(1):
						rent = this._houseRent1;
						break;
					case(2):
						rent = this._houseRent2;
						break;
					case(3):
						rent = this._houseRent3;
						break;
					case(4):
						rent = this._houseRent4;
						break;
					}
				}
				
				try {
					b.rent(_ownerIndex, p.getIndex(), rent);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if (p.isBankrupt())
					return;
				
				JOptionPane.showMessageDialog(jf,"PLAYER " + ((int)p.getIndex() + 1) + 
						": You Lost "+ rent + "!","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else //Prompt to buy this property's houses or hotels
			{
				if (this.getHouse() < 4 && b.getHouseCount() > 0)
				{
					String input = JOptionPane.showInputDialog(jf,"PLAYER " + ((int)p.getIndex() + 1) +
							": Input the amount of houses you want to buy [Put 0 if none]"
							+ "[Cost Per House: " + _buildingCost + "]");
					
					if (input.isEmpty())
						return;
					
					int costs = Integer.parseInt(input);
					
					costs = costs > b.getHotelCount() ? (costs - b.getHotelCount()) : costs;
				
					JOptionPane.showMessageDialog(jf,"PLAYER " + ((int)p.getIndex() + 1) + 
							": You spent " + ((int)(costs > 4 ? 4: costs) * this.getBuildingCost()) + " on buying houses!");
					
					p.boughtHouse(costs);
					b.useHouse(costs);
					this.buyHouse(p,costs);
				}
				
				if (this.getHouse() == 4 && b.getHotelCount() > 0)
				{
					int option = JOptionPane.showConfirmDialog(jf,"PLAYER " + ((int)p.getIndex() + 1) + 
						": Do you want to buy a Hotel? [COST:" + _buildingCost + "]");
					if (option == JOptionPane.YES_OPTION)
					{
						if (this.buyHotel(p))
						{
							JOptionPane.showMessageDialog(jf, "Player " + ((int)p.getIndex() + 1) + " has purchased a Hotel!");
							this._hotel = true;
							p.boughtHotel();
							b.useHotel();
							return;
						}
						else
						{
							JOptionPane.showMessageDialog(jf,"PLAYER " + ((int)p.getIndex() + 1) +
									": You do not have enough for this!");
							return;
						}
					}
					else
						return;
				}
				
			}
		}
	}

	@Override
	public int getOwnerIndex() 
	{
		return _ownerIndex;
	}
	
	@Override
	public void sellSpace(player p) {
		if (p.getIndex() != this.getOwnerIndex())
			throw new IllegalArgumentException("DOES NOT OWN THIS PROPERTY!");
		
		//Check if there is hotel first
		//Then check if there is houses after
		//Then sell the empty property
		//I think it would be best to exit every time they sell.
		JFrame jf = new JFrame();
		
		if (this.getHotel())
		{
			this._hotel = false;
			p.manipulateMoney(_buildingCost);
			this._houses = 4;
			
			JOptionPane.showMessageDialog(jf, "PLAYER " + ((int)p.getIndex() + 1) + " HAS SOLD A HOTEL ON "
					+ this.getName() + '.');
			
			return;
		}
		else if (this.getHouse() > 0)
		{
			String input = JOptionPane.showInputDialog(jf,"PLAYER " + ((int)p.getIndex() + 1) +
					": Input the amount of houses you want to sell"
					+ "[Cost Per House: " + _buildingCost + "]");
			
			if (input.isBlank())
			{
				this.sellSpace(p);
				return;
			}
			
			int housesSold = Integer.parseInt(input);
			this._houses -= housesSold;
			if (this.getHouse() < 0) {this._houses = 0;}
			
			p.manipulateMoney(housesSold * this._buildingCost);
			
			
			JOptionPane.showMessageDialog(jf, "PLAYER " + ((int)p.getIndex() + 1) + " HAS SOLD " + housesSold + " ON "
					+ this.getName() + '.');
			
			return;
		}
		else
		{
			this._ownerIndex = -1;
			p.manipulateMoney(_cost);
			JOptionPane.showMessageDialog(jf, "PLAYER " + ((int)p.getIndex() + 1) 
					+ " HAS SOLD " + this.getName() + '.');
			return;
		}
		
	}
}
