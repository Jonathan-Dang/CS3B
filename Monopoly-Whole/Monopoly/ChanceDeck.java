package Monopoly;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Monopoly_Properties.Position_Relationships;

/**
 * The Chance Deck
 * @author Jonathan Dang
 *
 */
public class ChanceDeck {
	private Random _randomNumberGenerator;
	private Position_Relationships space;
	
	/**
	 * Constructs a Chance Deck
	 */
	public ChanceDeck()
	{
		_randomNumberGenerator = new Random();
	}
	
	/**
	 * Draws a random Card
	 * @param p The Player
	 * @param b The Board
	 */
	public void drawCard(player p, Board b)
	{
		int card = _randomNumberGenerator.nextInt(16);
		String output = "";
		JFrame jf = new JFrame();
		
		switch (card)
		{
		case(0):
			p.moveToGo();
			output = "Advance to GO!";
			break;
		case(1):
			space = Position_Relationships.ILLINOISE_AVENUE;
			if (p.getLocation() > space.getLocation())
			{
				p.manipulateMoney(200);
			}
			p.setLocation(space.getLocation());
			output = "Advance to Illinois Ave";
			break;
		case(2):
			space = Position_Relationships.SAINT_CHARLES_PLACE;
			if(p.getLocation() > space.getLocation())
				p.manipulateMoney(200);
			p.setLocation(space.getLocation());
			output = "Advance to St. Charles Place";
			break;
		case(3):
			int Waterworks = Position_Relationships.WATER_WORKS.getLocation();
			int Electrical = Position_Relationships.ELECTRIC_COMPANY.getLocation();
			
			if (p.getLocation() > Waterworks) //Electrical is closer
			{
				p.manipulateMoney(200);
				p.setLocation(Electrical);
			}
			else if (p.getLocation() > Electrical && p.getLocation() < Waterworks)
			{
				p.setLocation(Waterworks);
			}
			else if (p.getLocation() > 0 && p.getLocation() < Electrical)
			{
				p.setLocation(Electrical);
			}
			
			b.activateCard(Electrical, p);
			
			output = "Advance token to the nearest Utility. If unowned, you may buy it from the Bank. "
					+ "If owned, throw dice and pay owner a total 10 times the amount thrown.";
			break;
		case(4):
			int Reading = Position_Relationships.READING_RAILROAD.getLocation();
			int Pennsylvania = Position_Relationships.PENNSYLVANIA_RAILROAD.getLocation();
			int Short = Position_Relationships.SHORT_LINE.getLocation();
			int BO = Position_Relationships.BBQ_RAILROAD.getLocation();
			
			if (p.getLocation() < Reading)
				p.setLocation(Reading);
			else if (p.getLocation() > Reading && p.getLocation() < Pennsylvania)
				p.setLocation(Pennsylvania);
			else if (p.getLocation() > Pennsylvania && p.getLocation() < BO)
				p.setLocation(BO);
			else if (p.getLocation() > BO)
				p.setLocation(Short);
			
			b.activateCard(p.getLocation(), p);
			
			output =  "Advance to the nearest Railroad. If unowned, you may buy it from the Bank."
					+ " If owned, pay owner twice the rent to which they are otherwise entitled."
					+ " If Railroad is unowned, you may buy it from the Bank.";
			break;
		case(5):
			p.manipulateMoney(50);
			
			output =  "Bank pays you dividend of $50";
			break;
		case(6):
			p.obtainGOFJC();
			
			output =  "Get out of Jail Free";
			break;
		case(7):
			p.setLocation(p.getLocation() - 3);
		
			output =  "Go Back Three 3 Spaces";

			b.activateCard(p.getLocation(), p);
			break;
		case(8):
			if(p.hasGOFJC())
			{
				int use = JOptionPane.showConfirmDialog(jf,"Use Get out of Jail Free Card?");
			
				if (use == JOptionPane.YES_OPTION)
					p.goToJail(true);
				else
				{
					p.goToJail(false);
					JOptionPane.showMessageDialog(jf,"PLAYER " + ((int) p.getIndex() + 1) +
							" HAS BEEN SENT TO JAIL!","Alert",JOptionPane.WARNING_MESSAGE);
				}
			}
			else
			{
				p.goToJail(false);
				JOptionPane.showMessageDialog(jf,"PLAYER " + ((int) p.getIndex() + 1) +
						" HAS BEEN SENT TO JAIL!","Alert",JOptionPane.WARNING_MESSAGE);
			}
				
			
			output = "Go Directly to Jail!";
			break;
		case(9):
			p.makeRepairs(25,100);
			
			output = "Make general repairs on all your property: For each house pay $25, For each hotel pay $100";
			break;
		case(10):
			p.manipulateMoney(-15);
		
			output = "Pay poor tax of $15";
			break;
		case(11):
			if (p.getLocation() > Position_Relationships.READING_RAILROAD.getLocation())
				p.manipulateMoney(200);
			
			p.setLocation(Position_Relationships.READING_RAILROAD.getLocation());
			output = "Take a trip to Reading Railroad";
			break;
		case(12):
			p.setLocation(Position_Relationships.BOARDWALK.getLocation());
		
			output = "Take a walk on the Boardwalk. Advance token to Boardwalk.";
			break;
		case(13):
			b.extortPlayer(p, 50);
			output = "You have been elected Chairman of the Board. Pay each player $50.";
			break;
		case(14):
			p.manipulateMoney(150);
			
			output = "Your building and loan matures. Receive $150";
			break;
		case(15):
			p.manipulateMoney(100);
			
			output = "You have won a crossword competition. Collect $100.";
			break;
		}
		
		JOptionPane.showMessageDialog(jf,output,"Alert",JOptionPane.WARNING_MESSAGE);
	}
}
