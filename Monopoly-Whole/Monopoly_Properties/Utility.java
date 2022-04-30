package Monopoly_Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Monopoly.Board;
import Monopoly.DiceRoller;
import Monopoly.Spaces;
import Monopoly.player;

/**
 * Utility Space
 * @author Jonathan Dang 
 *
 */
public class Utility extends Spaces{
	private int _ownerIndex = -1;
	private final int _cost = 150;
	
	/**
	 * Constructs a Utility Space
	 * @param n The Name
	 */
	public Utility(String n) {
		super(n);
	}

	/**
	 * Buys or Rents the Space
	 */
	@Override
	public void activateSpace(player p, Board b) {
		JFrame jf = new JFrame();
		if (_ownerIndex >= 0)
		{
			if (_ownerIndex != p.getIndex())
			{
				//Rent!
				int roll = DiceRoller.rollDice();
				int rent = 0;
				
				switch(p.getUtilsOwned())
				{
				case(1):
					rent = 4 * roll;
					break;
				case(2):
					rent = 10 * roll;
					break;
				}
				
				try {
					b.rent(_ownerIndex, p.getIndex(), rent);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if (p.isBankrupt())
					return;
			
				JOptionPane.showMessageDialog(jf,"PLAYER " + ((int)p.getIndex() + 1) + 
						": You Lost "+ rent + "!","Alert",JOptionPane.WARNING_MESSAGE);
			}
		}
		else
		{
			int option = JOptionPane.showConfirmDialog(jf,"PLAYER " + ((int)p.getIndex() + 1) + ": Buy " + this.getName() +"?");
			if (option == JOptionPane.YES_OPTION)
			{
				if (p.getBalance() < this._cost)
				{
					JOptionPane.showMessageDialog(jf,"PLAYER " + ((int)p.getIndex() + 1) + 
							": You don't have enought money!","Alert",JOptionPane.WARNING_MESSAGE);  
					return;
				}
				p.manipulateMoney(-_cost);
				_ownerIndex = p.getIndex();
				
				JOptionPane.showMessageDialog(jf,"PLAYER " + ((int)p.getIndex() + 1) + ": You spent $" + this._cost + " on buying " + this.getName() + "!");
				p.buyUtil();
			}
			else
				return;
		}
	}

	/**
	 * Returns the Owner Index
	 * @return int the Owner's Index
	 */
	@Override
	public int getOwnerIndex() {
		return _ownerIndex;
	}

	/**
	 * Sells the property
	 */
	@Override
	public void sellSpace(player p) {
		if (p.getIndex() != this.getOwnerIndex())
			throw new IllegalArgumentException("DOES NOT OWN THIS PROPERTY!");
		
		this._ownerIndex = -1;
		p.manipulateMoney(_cost/2);
		JOptionPane.showMessageDialog(new JFrame(), "PLAYER " 
				+ ((int)p.getIndex() + 1) + " HAS SOLD " + this.getName() + '.');
	}

}
