package Monopoly_Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Monopoly.Board;
import Monopoly.Spaces;
import Monopoly.player;

/**
 * The Tax Space
 * @author pocke
 *
 */
public class Tax extends Spaces{
	private int _taxRate;
	
	/**
	 * Constructs the Tax Space
	 * @param Rate The Cost of the Tax
	 */
	public Tax(int Rate) {
		super("Tax");
		_taxRate = Rate;
	}

	/**
	 * Taxs the Player
	 */
	@Override
	public void activateSpace(player p, Board b) {
		JFrame jf = new JFrame();
		p.manipulateMoney(-_taxRate);
		JOptionPane.showMessageDialog(jf,"PLAYER " + ((int)p.getIndex() + 1) + 
				": You Lost "+ _taxRate + "!","Alert",JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * Returns -1
	 * @return int -1;
	 */
	@Override
	public int getOwnerIndex() {
		return -1;
	}

	/**
	 * Nothing
	 */
	@Override
	public void sellSpace(player p) {
		return;
	}

}
