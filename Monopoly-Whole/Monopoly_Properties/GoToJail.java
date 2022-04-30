package Monopoly_Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Monopoly.Board;
import Monopoly.Spaces;
import Monopoly.player;

/**
 * Go TO Jail Space
 * @author Jonathan Dang
 *
 */
public class GoToJail extends Spaces{

	/**
	 * Constructs the GoToJail
	 */
	public GoToJail() {
		super("Go To Jail!");
	}

	/**
	 * Sends the Player To Jail
	 */
	@Override
	public void activateSpace(player p, Board b) {
		JFrame jf = new JFrame();
		
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
	}

	@Override
	public int getOwnerIndex() {
		return -1;
	}
	
	@Override
	public void sellSpace(player p) {
		return;
	}
}
