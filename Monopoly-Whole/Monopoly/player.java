package Monopoly;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class player {
	private int _playerIndex;
	private int _location;
	private int _balance;
	private boolean _inJail;
	private boolean _getOutOfJailFreeCard;
	private boolean _bankruptcy;
	private int _housesBought;
	private int _hotelsBought;
	private int _trainsOwned;
	private int _utilsOwned;
	
	private static int INDEXCOUNT = 0;
	
	private String _name;
	private String _creditCardNumber;
	private int _playerIndicator;
	
	public static final String[] FIGURES = {"WHEELBARROW", "BATTLESHIP", "MONEY", "HORSE", "CAR"
			, "TRAIN", "THIMBLE", "CANNON", "SHOE", "DOG", "IRON", "HAT"};
	
	/**
	 * Constructs a player ment for the game MONOPOLY
	 */
	public player(int indicator, String name, String CCN)
	{
		_name = name;
		_creditCardNumber = CCN;
		
		if (indicator > 11 || indicator < 0)
		{
			Random r = new Random();
			int selection = r.nextInt(12);
			_playerIndicator = selection;
		}
		
		_playerIndex = INDEXCOUNT++;
		_location = 0;
		_balance = 1300;
		_inJail = false;
		_getOutOfJailFreeCard = false;
		_bankruptcy = false;
	}
	
	/**
	 * Returns the name of the player
	 * @return name
	 */
	public String getName()
	{
		return _name;
	}
	
	/**
	 * Players Normally will have a credit card number that is more like a serial number.
	 * This returns it
	 * @return CCN
	 */
	public String getCCN()
	{
		return _creditCardNumber;
	}
	
	/**
	 * Gets the game piece of the player
	 * @return a FIGURE
	 */
	public String getIndicator()
	{
		return FIGURES[_playerIndicator];
	}
	
	/**
	 * Moves the player to go
	 */
	public void moveToGo()
	{
		_location = 0;
		_balance += 200;
	}
	
	/**
	 * Sets the location of the player to the space
	 * @param space | The new location
	 */
	public void setLocation(int space)
	{
		int modified = -1;
		if (space > 39)
		{
			modified = space % 39;
			this.manipulateMoney(200);
		}
		
		if(modified > 0)
		{
			_location = modified;
		}
		else
		{
			_location = space;
		}
	}
	
	/**
	 * Returns the current balance of the player
	 * @return the balance
	 */
	public int getBalance()
	{
		return _balance;
	}
	
	/**
	 * Returns the location of the player
	 * @return the location
	 */
	public int getLocation()
	{
		return _location;
	}
	
	/**
	 * Increments the amount of Utilities owned
	 */
	public void buyUtil()
	{
		_utilsOwned++;
	}
	
	/**
	 * Returns the amount of Utilities Owned
	 * @return The amount of Utilities owned
	 */
	public int getUtilsOwned()
	{
		return _utilsOwned;
	}
	
	/**
	 * Adds a certain amount of houses to the player's record
	 * @param houses | The amount of houses bought
	 */
	public void boughtHouse(int houses)
	{
		_housesBought += houses;
	}
	
	/**
	 * Buys a hotel
	 */
	public void boughtHotel()
	{
		_housesBought -= 4;
		_hotelsBought++;
	}
	
	/**
	 * Returns the amount of houses bought by the player
	 * @return the amount of houses bought
	 */
	public int getHousesBought()
	{
		return _housesBought;
	}
	
	/**
	 * Returns the amount of hotels bought
	 * @return the amount of hotels bought
	 */
	public int getHotelsBought()
	{
		return _hotelsBought;
	}
	
	/**
	 * Manipulates the balance of the player with a certain amount
	 * @param money | The amount of money
	 */
	public void manipulateMoney(int money)
	{
		if (_balance + money < 0)
			declareBankruptcy();
		
		_balance += money;
	}
	
	/**
	 * Declares the player as Bankrupt and removes them from the game
	 */
	private void declareBankruptcy() {
		JFrame jf = new JFrame();
		JOptionPane.showMessageDialog(jf,"PLAYER " + ((int)this.getIndex() + 1) 
				+ " has declared Bankruptcy!","Alert",JOptionPane.WARNING_MESSAGE);
		this._bankruptcy = true;
	}

	/**
	 * Checks if the player has a Get out of jail free card
	 * @return  _getOutOfJailFreeCard
	 */
	public boolean hasGOFJC()
	{
		return _getOutOfJailFreeCard;
	}
	
	/**
	 * Gives the player a  getOutOfJailFreeCard
	 */
	public void obtainGOFJC()
	{
		_getOutOfJailFreeCard = true;
	}
	
	/**
	 * uses the getOutOfJailFreeCard
	 * @return True if the player has one
	 */
	public boolean useGOFJC()
	{
		if (_getOutOfJailFreeCard)
		{
			_getOutOfJailFreeCard = false;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Checks if the player is Bankrupt
	 * @return _bankruptcy
	 */
	public boolean isBankrupt()
	{
		return _bankruptcy;
	}
	
	/**
	 * Sends the player to jail
	 * @param useCard | True if they want to use the GetOutofJailFree Card
	 */
	public void goToJail(boolean useCard)
	{
		if(useCard && useGOFJC())
			_inJail = false;
		else
			_inJail = true;
		
		setLocation(10);
	}
	
	/**
	 * Buys a train
	 */
	public void buyTrain()
	{
		_trainsOwned++;
	}
	
	/**
	 * Returns the amount of trains owned
	 * @return trains owned
	 */
	public int getTrainsOwned()
	{
		return _trainsOwned;
	}
	
	/**
	 * Checks if the player is in jail
	 * @return true if in jail
	 */
	public boolean inJail()
	{
		return _inJail;
	}
	
	/**
	 * Puts the player out of jail
	 */
	public void getOutOfJail()
	{
		_inJail = false;
	}
	
	/**
	 * Returns the player's index
	 * @return player index
	 */
	public int getIndex()
	{
		return _playerIndex;
	}
	
	/**
	 * Checks the amount of houses and hotels owned, then calculates the total costs
	 * @param houseCost | Cost per house to repair
	 * @param hotelCost | Cost per hotel to repair
	 */
	public void makeRepairs(int houseCost, int hotelCost)
	{
		int costs = ((int)this.getHotelsBought() * hotelCost) + ((int)this.getHousesBought() * houseCost);
		manipulateMoney(-costs);
	}
}
