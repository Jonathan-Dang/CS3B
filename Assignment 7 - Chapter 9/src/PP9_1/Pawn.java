//Author: Jonathan Dang
//Project: PP 9.1
package PP9_1;
import java.util.ArrayList;

/**
 * Pawn Chess Piece
 * @author Jonathan Dang
 *
 */
public class Pawn extends ChessPiece
{
	/**
	 * Basic Constructor for the Subclass Pawn.
	 * @param coordinates
	 * @param p
	 */
	public Pawn(String coordinates, String p) 
	{
		super(coordinates,p);
	}
	
	/**
	 * Overload to Chess Piece canMoveTo()
	 * @returns all possible moves
	 */
	public ArrayList<String> canMoveTo()
	{
		if(!super.isValidPosition())
			return null;
		
		ArrayList<String> possible = new ArrayList<String>();
		char letter = super.getCoords().charAt(0);
		char num = super.getCoords().charAt(1);
		String result = Character.toString(letter);
		
		int pos = Integer.parseInt(Character.toString(num));
		
		if(super.getColor().contains("w"))
		{
			if(pos == 2)
			{
				possible.add(result + String.valueOf(pos + 1));
				possible.add(result + String.valueOf(pos + 2));
			}
			else
			{
				possible.add(result + String.valueOf(pos + 1));
			}
		}
		else if(super.getColor().contains("b"))
		{
			if(pos == 7)
			{
				possible.add(result + String.valueOf(pos - 1));
				possible.add(result + String.valueOf(pos - 2));
			}
			else
			{
				possible.add(result + String.valueOf(pos - 1));
			}
		}
		
		return possible;
	}
}
