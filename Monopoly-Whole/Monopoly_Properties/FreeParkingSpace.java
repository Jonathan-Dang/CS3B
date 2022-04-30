package Monopoly_Properties;

import Monopoly.Board;
import Monopoly.Spaces;
import Monopoly.player;

/**
 * The Free Parking Space
 * @author Jonathan Dang
 *
 */
public class FreeParkingSpace extends Spaces{

	/**
	 * Constructs a Free Parking Space
	 */
	public FreeParkingSpace() {
		super("Free Parking!");
	}

	/**
	 * Does Nothing :D
	 */
	@Override
	public void activateSpace(player p, Board b) {
		//Do Absolutely Nothing!!! :D
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
