//Author: Jonathan Dang
//Project: PP 9.1
package PP9_1;
import java.util.ArrayList;

/**
 * Basic Rook Chess Piece
 * @author Jonathan Dang
 *
 */
public class Rook extends ChessPiece
{
	/**
	 * Constructs Subclass Rook
	 * @param Coords
	 * @param Player
	 */
	public Rook(String Coords, String Player)
	{
		super(Coords,Player);
	}
	
	/**
	 * Override canMoveTo()
	 * @returns all possible moves
	 */
	public ArrayList<String> canMoveTo()
	{
		if(!super.isValidPosition())
			return null;
		
		ArrayList<String> possible = new ArrayList<String>();
		int currentRow = Integer.parseInt(getCoords().substring(1));
		
		//Same Column Loop
		for(int i = 1; i <= 8; i++)
		{
			if(i != currentRow)
				possible.add(getCoords().charAt(0) + String.valueOf(i));
		}
		
		//Same Row Loop
		for(int i = 1; i < 8; i++)
		{
			possible.add(cols[i] + getCoords().substring(1));
		}
		
		return possible;
	}
}
