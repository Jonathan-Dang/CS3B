package Monopoly_Properties;

import Monopoly.Board;
import Monopoly.CommunityChestDeck;
import Monopoly.Spaces;
import Monopoly.player;

/**
 * The Community Chest Space
 * @author Jonathan Dang
 *
 */
public class CommunityChestSpace extends Spaces{
	private final CommunityChestDeck _CCD = new CommunityChestDeck();
	
	/**
	 * Contructs a Chest Space
	 */
	public CommunityChestSpace() {
		super("Community Chest");
	}

	/**
	 * Draws a Card
	 */
	@Override
	public void activateSpace(player p, Board b) {
		_CCD.drawCard(p, b);
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
