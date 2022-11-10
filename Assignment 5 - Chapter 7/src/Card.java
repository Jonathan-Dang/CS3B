//Author: Jonathan Dang
//Assignment 5 | Chapter 7
import java.util.Random;

/**
 * Fundamental object for the Poker game code that acts like a Card
 * @author Jonathan
 *
 */
public class Card {
	final private Random rand = new Random();
	private int suit;
	private int number;
	
	/**
	 * Creates a card using the parameters given.
	 * @param Suit
	 * @param Rank
	 */
	Card(int s, int n)
	{
		if(s < 0 || s > 4)
			suit = rand.nextInt(4) + 1;
		else
			suit = s;
		
		if(n < 0 || n > 13)
			number = rand.nextInt(13) + 1;
		else
			number = n;
	}
	
	/**
	 * Creates a random Card
	 */
	Card()
	{
		suit = rand.nextInt(4) + 1;
		number = rand.nextInt(13) + 1;
	}
	
	/**
	 * Returns the Suit as an integer
	 * @returns a Suit as int
	 */
	public int getSuit()
	{
		return suit;
	}
	
	/**
	 * Returns the rank as an Integer
	 * @return the Rank as int
	 */
	public int getNumber()
	{
		return number;
	}
	
	/**
	 * Determines the Suit's Name and returns it as a String
	 * @returns a string with Card's Suit's Name
	 */
	public String suitToString()
	{
		switch(suit)
		{
		case(1):
			return "Diamonds";
		case(2):
			return "Clovers";
		case(3):
			return "Hearts";
		case(4):
			return "Spades";
		default:
			return "";
		}
	}
	
	/**
	 * Comparative method checking suit and rank
	 * @param a Card
	 * @return true if this is bigger than c
	 */
	public boolean biggerThan(Card c)
	{
		if(c.suit > this.suit)
			return false;
		else if(c.number > this.number)
			return false;
		else
			return true;
	}
	
	/**
	 * Card print override
	 * @returns a String of the card
	 */
	@Override
	public String toString()
	{
		if(getNumber() < 11)
			return getNumber() + " of " + suitToString();
		else
			switch(getNumber())
			{
			case(11):
				return "Jack of " + suitToString();
			case(12):
				return "Queen of " + suitToString();
			case(13):
				return "King of " + suitToString();
			default:
				return getNumber() + " of " + suitToString();
			}
	}
}
