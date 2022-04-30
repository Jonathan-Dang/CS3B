package Monopoly_Properties;

import Monopoly.Board;
import Monopoly.Spaces;
import Monopoly.player;

/**
 * The Go Space
 * @author Jonathan Dang
 *
 */
public class GoSpace extends Spaces{

	/**
	 * Constructs the Go Space
	 */
	public GoSpace() {
		super("GO");
	}
	
	//Keep in mind that you get 200 if you land OR pass GO!
	/**
	 * Gives the Player 200 Currency
	 */
	@Override
	public void activateSpace(player p, Board b) {
		p.manipulateMoney(200);
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
