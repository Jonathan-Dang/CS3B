package Monopoly_Properties;

import Monopoly.Board;
import Monopoly.ChanceDeck;
import Monopoly.Spaces;
import Monopoly.player;

/**
 * The Chance Space
 * @author Jonathan Dang
 *
 */
public class ChanceSpace extends Spaces{
	private final ChanceDeck _chanceD = new ChanceDeck();

	/**
	 * Contructs a Chance Space
	 */
	public ChanceSpace() {
		super("Chance!");
	}

	/**
	 * Draws a Card
	 */
	@Override
	public void activateSpace(player p, Board b) {
		_chanceD.drawCard(p, b);
	}

	@Override
	public int getOwnerIndex() 
	{
		return -1;
	}

	@Override
	public void sellSpace(player p) {
		return;
	}
}
