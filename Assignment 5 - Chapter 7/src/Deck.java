//Author: Jonathan Dang
//Assignment 5 | Chapter 7
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Deck object that keeps track of a deck
 * @author Jonathan
 *
 */
public class Deck {
	private ArrayList<Card> _deck;
	
	/**
	 * Constructs a deck like its fresh from the store and sealed
	 */
	Deck()
	{
		_deck = new ArrayList<Card>();
		for(int i = 1; i <= 4; i++)
		{
			for(int t = 1; t <= 13; t++)
			{
				_deck.add(new Card(i,t));
			}
		}
	}
	
	/**
	 * shuffles this deck atleast once but no more than 13 times
	 */
	public void shuffle()
	{
		Random rand = new Random();
		for(int i = 1; i < rand.nextInt(13);i++)
		{
			Collections.shuffle(_deck);
		}
	}
	
	/**
	 * Deals card from the deck
	 * @returns a Card
	 */
	public Card deal()
	{
		Card c = _deck.get(0);
		_deck.remove(0);
		return c;
	}
	
	/**
	 * Throws this deck away and replaces it with a fresh deck
	 */
	public void newDeck()
	{
		_deck.clear();
		for(int i = 1; i <= 4; i++)
		{
			for(int t = 1; t <= 13; t++)
			{
				_deck.add(new Card(i,t));
			}
		}
	}
	
	/**
	 * Checks if this deck is empty
	 * @return true if empty
	 */
	public boolean isEmpty()
	{
		return _deck.isEmpty();
	}
	
	/**
	 * Returns the amount of cards left in this deck
	 * @returns size
	 */
	public int size()
	{
		return _deck.size();
	}
}
