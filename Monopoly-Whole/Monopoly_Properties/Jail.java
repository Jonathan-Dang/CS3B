package Monopoly_Properties;

import Monopoly.Board;
import Monopoly.Spaces;
import Monopoly.player;

/**
 * The Jail
 * @author Jonathan Dang
 *
 */
public class Jail extends Spaces{

	/**
	 * Constructs a Jail Space
	 */
	public Jail() {
		super("Jail");
	}

	/**
	 * Does Nothing, PlaceHolder as for the Jail ROLL in Board
	 */
	@Override
	public void activateSpace(player p, Board b) {
		// Well, this space doesn't really do anything but it does skip your turn if you are in jail.
		
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
