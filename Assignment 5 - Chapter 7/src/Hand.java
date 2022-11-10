//Author: Jonathan Dang
//Assignment 5 | Chapter 7
import java.util.ArrayList;

/**
 * The Hand object is used to calculate the type and value of any given set of 5 Cards
 * @author Jonathan
 *
 */
public class Hand {
	private Card[] hand;
	
	/**
	 * Creates an assumably full hand from the given Card Array
	 * @param h
	 */
	public Hand(Card[] h)
	{
		hand = h.clone();
		sortHand(hand);
	}
	
	/**
	 * Creates an assumably full hand from the given Card ArrayList
	 * @param h
	 */
	public Hand(ArrayList<Card> h)
	{
		hand = new Card[5];
		for(int i = 0; i < 5 && i < h.size(); i++)
		{
			hand[i] = h.get(i);
		}
		sortHand(hand);
	}
	
	/**
	 * Returns a copy of the Card array
	 * @return hand
	 */
	public Card[] getHand()
	{
		return hand.clone();
	}
	
	/**
	 * Returns a copy of the Card array as an Array List
	 * @return array list hand
	 */
	public ArrayList<Card> getHandList()
	{
		ArrayList<Card> h = new ArrayList<Card>();
		for(int i = 0; i < hand.length; i++)
		{
			h.add(hand[i]);
		}
		return h;
	}
	
	/**
	 * Calculates the score given from the stored hand
	 * @return score
	 */
	public int scoreHand()
	{
		if(isOnePair())
		{
			return 1;
		}
		else if(isTwoPair())
		{
			return 2;
		}
		else if(isThreeofaKind())
		{
			return 3;
		}
		else if(isFullHouse())
		{
			return 6;
		}
		else if(isFourofaKind())
		{
			return 25;
		}
		//Full-Hand Values
		else if(isStraight())
		{
			return 4;
		}
		else if(isFlush())
		{
			return 5;
		}
		//Combo Hand
		else if(isStraightFlush())
		{
			return 50;
		}
		//Rarest Value
		else if(isRoyalStraightFlush())
		{
			return 250;
		}
		else
		{
			return 0;
		}
		
	}
	
	/**
	 * Uses the stored hand to calculate the type of hand and returns a string
	 * @return hand name
	 */
	public String judgeHand()
	{
		String judged = "";
		//Non Full-Hand values
		if(isOnePair())
		{
			judged = "One Pair, ";
		}
		else if(isTwoPair())
		{
			judged = "Two Pair, ";
		}
		else if(isThreeofaKind())
		{
			judged = "Three of a Kind, ";
		}
		else if(isFullHouse())
		{
			judged = "Full House, ";
		}
		else if(isFourofaKind())
		{
			judged = "Four of a Kind, ";
		}
		
		//Full-Hand Values
		if(isStraight())
		{
			judged = "Straight, ";
		}
		else if(isFlush())
		{
			judged = "Flush, ";
		}
		
		//Combo Hand
		if(isStraightFlush())
		{
			judged = "Straight Flush, ";
		}
		
		//Rarest Value
		if(isRoyalStraightFlush())
		{
			return "Royal Straight Flush of " + hand[0].suitToString();
		}
		
		if(judged.isEmpty())
			judged = "No Pair, ";
		
		return judged + getHighestCard();
	}
	
	/**
	 * Finds the highest value card
	 * @return highest card
	 */
	public String getHighestCard()
	{
		Card highest = hand[0];
		for(int i = 1; i < hand.length;i++)
		{
			if(!highest.biggerThan(hand[i]))
				highest = hand[i];
		}
		
		return highest.toString() + " High";
	}
	
	/**
	 * Determines if the hand is a royal straight flush.
	 * @return true if is RSF
	 */
	public boolean isRoyalStraightFlush()
	{
		if(!isFlush())
			return false;
		boolean a1;
		
		a1 = hand[0].getNumber() == 1 && hand[1].getNumber() == 10 &&
				hand[2].getNumber() == 11 && hand[3].getNumber() == 12 &&
				hand[4].getNumber() == 13;
		
		return a1;
	}
	
	/**
	 * Determines if the hand is a Straight Flush
	 * @return true if is SF
	 */
	public boolean isStraightFlush()
	{
		return isStraight() && isFlush();
	}
	
	/**
	 * Determines if the hand is a Straight
	 * @return true if is Straight
	 */
	public boolean isStraight()
	{
		Card temp = hand[0];
		for(int i = 1; i < hand.length;i ++)
		{
			if(temp.getNumber() + 1 != hand[i].getNumber())
				return false;
			
			temp = hand[i];
		}
		return true;
	}
	
	/**
	 * Determines if the hand is a Four of a kind
	 * @return true if is a FOAK
	 */
	public boolean isFourofaKind()
	{
		boolean a1,a2;
		// a a a a x
		a1 = hand[0] == hand[1] &&
			hand[1] == hand[2] &&
			hand[2] == hand[3];
		// x a a a a
		a2 = hand[1] == hand[2] &&
			hand[2] == hand[3] &&
		    hand[3] == hand[4];
		
		return (a1 || a2);
	}
	
	/**
	 * Determines if the hand is a Two Pair
	 * @return true if is a TP
	 */
	public boolean isTwoPair()
	{
		if(isFourofaKind() || isFullHouse() || isThreeofaKind())
			return false;
		boolean a1, a2, a3;
		// a a b b x
	    a1 = hand[0] == hand[1] && hand[2] == hand[3];
	    // a a x b b
	    a2 = hand[0] == hand[1] && hand[3] == hand[4];
	    // x a a b b
	    a3 = hand[1] == hand[2] && hand[3] == hand[4];
	    
	    return( a1 || a2 || a3 );
	}
	
	/**
	 * Determines if the hand is a One Pair
	 * @return true if is a OP
	 */
	public boolean isOnePair()
	{
		if(isTwoPair() || isFourofaKind() || isThreeofaKind() || isFullHouse())
			return false;
		boolean a1,a2,a3,a4;

		// a a x x x
		a1 = hand[0] == hand[1];
		// x a a x x
	    a2 = hand[1] == hand[2];
	    // x x a a x
	    a3 = hand[2] == hand[3];
	    // x x x a a
	    a4 = hand[3] == hand[4];
	    
	    return (a1 || a2 || a3 || a4);
	}
	
    /**
     * Determines if the hand is a Three of a kind
     * @return true if is a TOAK
     */
	public boolean isThreeofaKind()
	{
		if(isFourofaKind() || isFullHouse())
			return false;
		boolean a1,a2,a3;
		// a a a x x
		a1 = hand[0] == hand[1] && hand[1] == hand[2];
		// x a a a x
		a2 = hand[1] == hand[2] && hand[2] == hand[3];
		// x x a a a
		a3 = hand[2] == hand[3] && hand[3] == hand[4];

		return( a1 || a2 || a3 );
	}
	
	/**
	 * Determines if the hand is a Full House
	 * @return true if is a Full house
	 */
	public boolean isFullHouse()
	   {
	      boolean a1, a2;

	      // a a a b b
	      a1 = hand[0] == hand[1] &&
	           hand[1] == hand[2] &&
	           hand[3] == hand[4];

	      // a a b b b
	      a2 = hand[0] == hand[1] &&
	           hand[2] == hand[3] &&
	           hand[3] == hand[4];

	      return( a1 || a2 );
	   }
	
	/**
	 * Determines if the hand is a Flush
	 * @return true if is a flush
	 */
	public boolean isFlush()
	{
		Card c = hand[0];
		for(int i = 0; i < hand.length;i++)
		{
			if(c.getSuit() != hand[i].getSuit())
				return false;
		}
		return true;
	}
	
	/**
	 * Private method that sorts the card array using the stored hand
	 * @param hand
	 */
	private void sortHand(Card[] h)
	{
		int min = 0;
		
		for(int i = 0; i < h.length; i++)
		{
			min = i;
			for(int j = i + 1; j < h.length; j++)
			{
				if(h[j].getNumber() < h[min].getNumber())
					min = j;
			}
			Card temp = h[i];
			h[i] = h [min];
			h[min] = temp;
		}
	}
}
