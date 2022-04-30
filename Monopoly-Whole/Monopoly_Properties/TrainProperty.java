package Monopoly_Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Monopoly.Board;
import Monopoly.Spaces;
import Monopoly.player;

/**
 * The Train Property
 * @author Jonathan Dang
 *
 */
public class TrainProperty extends Spaces{
	private int _ownerIndex = -1;
	private final int _cost = 200;
	private int _rentMod = 50;
	public static final int READING = 5;
	public static final int PENNSYLVANIA = 15;
	public static final int BBO = 25;
	public static final int SHORT = 35;
			
	/**
	 * Constructs a Train Property
	 * @param n The name
	 */
	public TrainProperty(String n) {
		super(n);
	}
	
	/**
	 * Returns the Owner Index
	 * @return int the owner's Index
	 */
	@Override
	public int getOwnerIndex()
	{
		return _ownerIndex;
	}

	/**
	 * Buys, Rents, or sells the Property
	 */
	@Override
	public void activateSpace(player p, Board b) {
		// TODO Check on each Train Property, The amount owned will determine Rent
		JFrame jf = new JFrame();
		if (_ownerIndex >= 0)
		{
			//Rent!
			if (_ownerIndex != p.getIndex())
			{
				int rent = _rentMod * p.getTrainsOwned();
			
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
				p.buyTrain();
			}
			else
				return;
		}
		
	}
	
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
