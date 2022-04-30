package Monopoly;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Helpers.SellingFrame;
import Monopoly_Properties.*;

/**
 * The Board holds all player interactions and property interactions
 * @author Jonathan Dang
 *
 */
public class Board {
	private Spaces[] _board = new Spaces[40];
	private player[] _players;
	private int[] _jailTimer = new int[4];
	private int _hotelAmount;
	private int _houseAmount;
	private int _turn; //_turn controls which player is active!, _round keeps track of how many turns/4 was done
	
	//I want to limit the amount of players since games are usually longer and more complex the more players there is.
	//The rules I implemented for this also forces for a simpler version of the game.
	//The Limit is 4 players. Only Multi-player is allowed.
	//Passing or Landing on the GO space will give you 200
	
	//Selling Properties will require the player's index on the current turn,
	//We will use the _turn as the current player wanting to sell or being forced to sell to the bank
	//All selling will not be between players, but rather only be with the bank.
	
	/**
	 * Constructs a board with a set amount of players
	 * @param players | The players
	 */
	public Board(player[] players)
	{
		_players = players.clone();
		_hotelAmount = 12;
		_houseAmount = 32;
		_turn = 0;
		for (int i = 0; i < 4; i++)
		{
			_jailTimer[i] = 0;
		}
		createBoard();
	}
	
	/**
	 * Initializes the Board
	 */
	private void createBoard()
	{
		/*
		 * Property(String name, int price, int rent, int HouseRent1,
			int HouseRent2, int HouseRent3, int HouseRent4, int hotelRent, int buildingCost)
		 */
		_board[0] = new GoSpace();
		_board[1] = new Property("MEDITERANEAN AVENUE", 60, 2, 10, 30, 90, 160, 250, 50);
		_board[2] = new CommunityChestSpace();
		_board[3] = new Property("BALTIC AVENUE", 60, 2, 20, 60, 180, 320, 450, 50);
		_board[4] = new Tax(200);
		_board[5] = new TrainProperty("READING RAILROAD");
		_board[6] = new Property("ORIENTAL AVENUE", 100, 6, 30, 90, 270, 400, 550, 50);
		_board[7] = new ChanceSpace();
		_board[8] = new Property("VERMONT AVENUE", 100, 6, 30, 90, 270, 400, 550, 50);
		_board[9] = new Property("CONNECTICUT AVENUE", 120, 8, 40, 100, 300, 450, 600, 50);
		_board[10] = new Jail();
		_board[11] = new Property("ST. CHARLES PLACE", 140, 10, 50, 150, 450, 625, 750, 100);
		_board[12] = new Utility("ELECTRIC COMPANY");
		_board[13] = new Property("STATES AVENUE", 140, 10, 50, 150, 450, 625, 750, 100);
		_board[14] = new Property("VIRGINIA AVENUE", 160, 12, 60, 180, 500, 700, 900, 100);
		_board[15] = new TrainProperty("PENNSYLVANIA RAILROAD");
		_board[16] = new Property("ST. JAMES PLACE", 180, 14, 70, 200, 550, 750, 950, 100);
		_board[17] = new CommunityChestSpace();
		_board[18] = new Property("TENNESSEE AVENUE", 180, 14, 70, 200, 550, 750, 950, 100);
		_board[19] = new Property("NEW YORK AVENUE", 200, 16, 80, 220, 600, 800, 1000, 100);
		_board[20] = new FreeParkingSpace();
		_board[21] = new Property("KENTUCKY AVENUE", 220, 18, 90, 250, 700, 875, 1050, 150);
		_board[22] = new ChanceSpace();
		_board[23] = new Property("INDIANA AVENUE", 220, 18, 90, 250, 700, 875, 1050, 150);
		_board[24] = new Property("ILLINOIS AVENUE", 240, 20, 100, 300, 750, 925, 1100, 150);
		_board[25] = new TrainProperty("B.B.O. RAILROAD");
		_board[26] = new Property("ATLANTIC AVENUE", 260, 22, 110, 330, 800, 975, 1150, 150);
		_board[27] = new Property("VENTOR AVENUE", 260, 22, 110, 330, 800, 975, 1150, 150);
		_board[28] = new Utility("WATER WORKS");
		_board[29] = new Property("MARVIN GARDENS", 280, 24, 120, 360, 850, 1025, 1200, 150);
		_board[30] = new GoToJail();
		_board[31] = new Property("PACIFIC AVENUE", 300, 26, 130, 390, 900, 1100, 1275, 200);
		_board[32] = new Property("NORTH CAROLINA AVENUE", 300, 26, 130, 390, 900, 1100, 1275, 200);
		_board[33] = new CommunityChestSpace();
		_board[34] = new Property("PENNSYLVANIA AVENUE", 320, 28, 150, 450, 1000, 1200, 1400, 200);
		_board[35] = new TrainProperty("SHORT LINE");
		_board[36] = new ChanceSpace();
		_board[37] = new Property("PARK PLACE", 350, 35, 175, 500, 1100, 1300, 1500, 200);
		_board[38] = new Tax(100);
		_board[39] = new Property("BOARDWALK", 400, 50, 200, 600, 1400, 1700, 2000, 200);
	}
	
	/**
	 * Returns all player data at this specific time
	 * @return ArrayList<player> The Player Data
	 */
	public ArrayList<player> getPlayerData()
	{
		ArrayList<player> playerData = new ArrayList<player>();
		for (player p : _players)
		{
			playerData.add(p);
		}
		return playerData;
	}
	
	/**
	 * Advances the current player's turn by moving through the board
	 */
	public void Go()
	{
		int roll = DiceRoller.rollDice();
		this.movePlayer(roll);
	}
	
	/**
	 * Gets the name of the location
	 * @return String the location name
	 */
	public String getLocationName()
	{
		return _board[_players[_turn].getLocation()].getName();
	}
	
	/**
	 * Gets the turn counter's position
	 * @return int the turn
	 */
	public int getTurn()
	{
		return _turn;
	}
	
	/**
	 * Returns the entire player's of whomst the turn it is
	 * @return player the Player
	 */
	public player getCurrentTurnPlayer()
	{
		return _players[_turn];
	}
	
	/**
	 * Moves the player a certain amount
	 * @param move the amount of spaces moved
	 */
	public void movePlayer(int move)
	{
		player p = _players[_turn];
		if (!p.inJail())
		{
			p.setLocation(p.getLocation() + move);

			activateCard(p.getLocation(),p);
		}
		else
		{
			this.jailRoll(p);
		}

		//nextTurn();
	}
	
	/**
	 * Advances the turn counter by one
	 */
	public void nextTurn()
	{
		int turn = 0;
		if (_turn + 1 >= _players.length)
		{
			for (int i = 0; i < _players.length; i ++)
			{
				if (!_players[i].isBankrupt())
				{
					turn = i;
					break;
				}
			}
			_turn = turn;
		}
		else
		{
			_turn++;
		}
			
	}
	
	/**
	 * Detects whether or not the game has a winner
	 * @return boolean True if the game has a winner
	 */
	public boolean hasWinner()
	{
		int bankrupts = 0;
		for (player p : _players)
		{
			if (p.isBankrupt())
				bankrupts++;
		}
		return bankrupts == 3;
	}
	
	/**
	 * Returns the winner as a player
	 * @return player The winner
	 */
	public player getWinner()
	{
		for (player p : _players)
		{
			if (!p.isBankrupt())
				return p;
		}
		
		return null;
	}
	
	/**
	 * Activates the space
	 * @param spaceIndex The space itself
	 * @param p The Player
	 */
	public void activateCard(int spaceIndex, player p)
	{
		if (!p.isBankrupt())
			_board[spaceIndex].activateSpace(p, this);
	}
	
	/**
	 * Decreases the total amount of usable houses by an amount
	 * @param amount the houses used
	 */
	public void useHouse(int amount)
	{
		if (_houseAmount <= 0)
			return;
		
		_houseAmount -= amount;
	}
	
	/**
	 * Gets the current useable house count
	 * @return int the House Count
	 */
	public int getHouseCount()
	{
		return _houseAmount;
	}
	
	/**
	 * Decreases the total amount of usable hotel by 1
	 */
	public void useHotel()
	{
		if (_hotelAmount <= 0)
			return;
		_hotelAmount--;
	}
	
	/**
	 * Gets the current usable hotel Count
	 * @return int the Hotel count
	 */
	public int getHotelCount()
	{
		return _hotelAmount;
	}
	
	/**
	 * Rents the rentie person by Rent amount
	 * @param ownerIndex The owner of the property
	 * @param rentieIndex The rented Person
	 * @param rent The amount
	 * @throws InterruptedException E
	 */
	public void rent(int ownerIndex, int rentieIndex, int rent) throws InterruptedException
	{
		while (_players[rentieIndex].getBalance() < rent)
		{
			sell(rentieIndex,true);
		}
		
		_players[rentieIndex].manipulateMoney(-rent);
		_players[ownerIndex].manipulateMoney(rent);
	}
	
	/**
	 * Sells a property from the player's ownership
	 * @param playerIndex The player
	 * @param rented Determines if they were forced to sell or not
	 * @throws InterruptedException
	 */
	public void sell(int playerIndex, boolean rented) throws InterruptedException
	{
		//TODO: Get a list of owned properties.
		//Then display the list, sell the selected for half price
		//If there is a house or hotel, then sell those first.
		
		//Addendum 6/6/2021: Maybe add a String to the arguments to sell it after finding the index.
		//This way it makes it easier on the system.
		
		ArrayList<Integer> index = new ArrayList<Integer>();
		ArrayList<String> names = new ArrayList<String>();
		
		//Addendum 6/6/2021: SellingFrame doesn't work for some odd reason.
		//Maybe something conflicting with a frame and a dialog
		//Unsure but I guess I have to do it the old fasion way.
		SellingFrame SF = new SellingFrame(names);
		
		//I need a timer so that the user has an ample amount of time to select
		//a property in which to sell.
		//Addendum: This has been solved by using a JDialog instead of a JFrame as it
		//pauses the current thread to run the Dialog.
		//Addendum 6/1/2021: The above JDialog does not work, using a loop as well as the
		//static method Thread.sleep(LONG) will work fine
		
		String SelectedName = "";
		
		while (SelectedName.isEmpty())
		{
			Thread.sleep(1000);
			SelectedName = SF.getSelection();
		}
		
		int SelectedIndex = -1;
		
		for (int i = 0; i < index.size(); i++)
		{
			if (SelectedName.equals(names.get(i).toUpperCase()))
			{
				SelectedIndex = index.get(i);
			}
		}
		
		if (SelectedName.equals("NOTHING") && rented)
		{
			int option = JOptionPane.showConfirmDialog(new JFrame(), "Are you sure you want to not sell?\n You will be Bankrupt.");
			
			if (option == JOptionPane.YES_OPTION)
			{
				_players[playerIndex].manipulateMoney(-999999);
			}
			
		}
		else if (SelectedName.equals("NOTHING"))
			return;
		
		//Now I have to extract the cost of the property, Houses, hotels, etc...
		//Maybe a solution would be to add a sell method to all property types.
		//This seems to be the easiest to do.
		//Addendum 6/1/2021: Thinking it further, maybe it its simpler for me to 
		//create another abstract method for the type
		//Then check the typing to allow for selling.
		//Making the Util and Trains have the same name of a method would help as well.
		//It would be a better solution to just have an abstract sell method, since it would be
		//standardized.
		_board[SelectedIndex].sellSpace(_players[playerIndex]);
	}
	
	/**
	 * Extorts a player for other's gains
	 * @param p The player
	 * @param amount The amount
	 */
	public void extortPlayer(player p, int amount)
	{
		p.manipulateMoney(-3*amount);
		
		for(int i = 0; i < 4; i ++)
		{
			if (_players[i] != p)
				_players[i].manipulateMoney(amount);
		}
	}
	
	/**
	 * Absorbs the amount from other players
	 * @param p The Player
	 * @param amount The amount
	 */
	public void syphonPlayers(player p, int amount)
	{
		for (int i = 0; i < 4; i ++)
		{
			if (!_players[i].isBankrupt() && _players[i] != p)
			{
				_players[i].manipulateMoney(-amount);
			}
		}
		p.manipulateMoney(amount * 3);
	}
	
	/**
	 * Rolls for the Jail Ruling
	 * @param p The Prisoner
	 */
	public void jailRoll(player p)
	{
		if ( _jailTimer[p.getIndex()] == 3)
		{
			p.manipulateMoney(-50);
			p.getOutOfJail();
		}
		else
		{
			//Obtain Dice Roller Array option, check if they ==, true => set them free; else skip their turn.
			int[] rolledDice = DiceRoller.getDiceRolls();
			if (rolledDice[0] == rolledDice[1])
			{
				//The Player moves this selected amount and is out of jail.
				p.getOutOfJail();
				p.setLocation(p.getLocation() + rolledDice[0] + rolledDice[1]);
			}
			else
				_jailTimer[p.getIndex()]++;
		}
	}
}
