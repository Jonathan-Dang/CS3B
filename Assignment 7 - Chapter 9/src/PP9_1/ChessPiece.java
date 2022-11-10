package PP9_1;
import java.util.ArrayList;

/**
 * Super Class for all Chess Pieces
 * @author Jonathan Dang
 *
 */
public class ChessPiece {
	private String coords;
	private String player;
	public final static char[] cols = {'a','b','c','d','e','f','g','h'};
	
	/**
	 * Constructs a Chess Piece on Position Coordinates for Player p
	 * @param coordinates
	 * @param p
	 */
	public ChessPiece(String coordinates, String p)
	{
		coords = new String(coordinates);
		player = p.toLowerCase();
	}
	
	/**
	 * Returns currents Chess Coordinates
	 * @return coords
	 */
	public String getCoords()
	{
		return coords;
	}
	
	/**
	 * Returns all possible moves that this piece can do
	 * @return Moves
	 */
	public ArrayList<String> canMoveTo()
	{
		if(!isValidPosition())
			return null;
		
		return new ArrayList<String>();
	}
	
	/**
	 * Moves piece to Coordinates given
	 * @param coordinates
	 */
	public void setPosition(String coordinates)
	{
		String temp = coords;
		coords = coordinates;
		if(!isValidPosition())
			coords = temp;
		
	}
	
	/**
	 * Obtains the Owner of the piece
	 * @return player
	 */
	public String getColor()
	{
		return player;
	}
	
	/**
	 * Checks if the piece is in a valid position
	 * @returns true if it is valid
	 */
	public boolean isValidPosition()
	{
		char letter = coords.charAt(0);
		boolean tfCol = false;
		for(int i = 0; i < 8; i ++)
		{
			if(Character.compare(letter, cols[i]) == 0)
				tfCol = true;
		}
		int num = Integer.parseInt(getCoords().substring(1));
		
		if(!tfCol)
		{
			return false;
		}
		else if(num > 8 || num < 1)
		{
			return false;
		}
		
		return true;
	}
}
