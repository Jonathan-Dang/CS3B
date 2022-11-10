//Author: Jonathan Dang
//Assignment 5 | Chapter 7
import java.util.ArrayList;
import java.util.Scanner;

public class Source {
	public static void main(String[] arg)
	{
		Deck d = new Deck();
		d.shuffle();
		Scanner ins = new Scanner(System.in);
		
		ArrayList<Card> hand = new ArrayList<Card>();
		for(int i = 0; i < 5; i ++)
			hand.add(d.deal());
		
		
		System.out.println("You got Dealt: ");
		for(int i = 0; i < hand.size();i++)
			System.out.println(hand.get(i));
		
		System.out.print("Enter the positions of the cards you want to toss, enter 0 to keep your "
				+ "hand or to end the series:");
		ArrayList<Integer> removeCards = new ArrayList<Integer>();
		while(true)
		{
			int pos = ins.nextInt();
			if(pos == 0)
				break;
			removeCards.add(pos);
		}
		
		for(int i = 0; i < removeCards.size();i ++)
		{
			int pos = removeCards.get(i);
			if(pos != 0)
				hand.remove(pos - 1);
		}
		
		for(int i = 0; i < removeCards.size(); i ++)
			hand.add(d.deal());
		
		System.out.println("You got Dealt: ");
		for(int i = 0; i < hand.size();i++)
			System.out.println(hand.get(i));
		
		System.out.println("You have gotten...");
		Hand calcHand = new Hand(hand);
		System.out.println(calcHand.judgeHand());
		System.out.println("Score: " + calcHand.scoreHand());
		ins.close();
	}
}

/*
You got Dealt: 
1 of Clovers
10 of Spades
1 of Spades
2 of Diamonds
3 of Clovers
Enter the positions of the cards you want to toss, enter 0 to keep your hand or to end the series:1 2 0
You got Dealt: 
10 of Spades
2 of Diamonds
3 of Clovers
6 of Spades
10 of Diamonds
You have gotten...
No Pair, 10 of Spades High
Score: 0
*/
