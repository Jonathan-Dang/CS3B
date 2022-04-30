package Monopoly;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The Community Chest Deck
 * @author Jonathan Dang
 *
 */
public class CommunityChestDeck {
	private Random _randomNumberGenerator;
	
	/**
	 * Constructs a Community Chest Deck
	 */
	public CommunityChestDeck()
	{
		_randomNumberGenerator = new Random();
	}
	
	/**
	 * Draws a Card
	 * @param p The Player
	 * @param b The Board
	 */
	public void drawCard(player p, Board b)
	{
		int card = _randomNumberGenerator.nextInt(17);
		String output = "";
		JFrame jf = new JFrame();
		
		switch (card) {
		case(0):
			p.moveToGo();
			output = "Advance to GO!";
			break;
		case(1):
			p.manipulateMoney(200);
			output = "Bank error in your favor. Collect $200.";
			break;
		case(2):
			p.manipulateMoney(-50);
			output = "Doctor's fees. Pay $50.";
			break;
		case(3):
			p.manipulateMoney(50);
			output = "From sale of stock you get $50.";
			break;
		case(4):
			p.obtainGOFJC();
			output = "Get Out of Jail Free!";
			break;
		case(5):
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
		case(6):
			b.syphonPlayers(p, 50);
			output = "Grand Opera Night. Collect $50 from every player for opening night seats.";
			break;
		case(7):
			p.manipulateMoney(100);
			output = "Holiday Fund matures. Receive $100.";
			break;
		case(8):
			p.manipulateMoney(20);
			output = "Income tax refund. Collect $20.";
			break;
		case(9):
			b.syphonPlayers(p, 10);
			output = "It is your birthday. Collect $10 from every player.";
			break;
		case(10):
			p.manipulateMoney(100);
			output = "Life insurance matures – Collect $100.";
			break;
		case(11):
			p.manipulateMoney(-50);
			output = "Hospital Fees. Pay $50.";
			break;
		case(12):
			p.manipulateMoney(-50);
			output = "School fees. Pay $50.";
			break;
		case(13):
			p.manipulateMoney(25);
			output = "Receive $25 consultancy fee.";
			break;
		case(14):
			p.makeRepairs(40, 115);
			output = "You are assessed for street repairs: Pay $40 per house and $115 per hotel you own.";
			break;
		case(15):
			p.manipulateMoney(10);
			output = "You have won second prize in a beauty contest. Collect $10.";
			break;
		case(16):
			p.manipulateMoney(100);
			output = "You inherit $100";
			break;
		}
		
		JOptionPane.showMessageDialog(jf,output,"Alert",JOptionPane.WARNING_MESSAGE);
	}
}
