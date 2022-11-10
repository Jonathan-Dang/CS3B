//Author: Jonathan Dang
//Project: PP 9.1
package PP9_1;
import java.util.ArrayList;

/**
 * Basic King Chess Piece
 * @author Jonathan Dang
 *
 */
public class King extends ChessPiece
{
	/**
	 * Constructs subclass King
	 * @param Coords
	 * @param Player
	 */
	public King(String Coords, String Player)
	{
		super(Coords,Player);
	}
	
	/**
	 * Overrides canMoveTo()
	 * @returns all possible moves
	 */
	public ArrayList<String> canMoveTo()
	{
		if(!super.isValidPosition())
			return null;
		
		ArrayList<String> possible = new ArrayList<String>();
		int currentCol = 0;
		for(int i = 0; i < 8; i++)
		{
			if(Character.compare(getCoords().charAt(0),cols[i]) != 0)
			{
				currentCol++;
			}
			else
				break;
		}
		int currentRow = Integer.parseInt(getCoords().substring(1));
		
		//Left Side
		if(currentCol - 1 > 0)
		{
			if(currentRow > 0 && currentRow <= 8)
			{
				possible.add(cols[currentCol - 1] + String.valueOf(currentRow));
				if(currentRow + 1 <= 8)
					possible.add(cols[currentCol - 1] + String.valueOf(currentRow + 1));
				if(currentRow - 1 > 0)
					possible.add(cols[currentCol - 1] + String.valueOf(currentRow - 1));
			}
		}
		
		//Right Side
		if(currentCol + 1 < 8)
		{
			if(currentRow > 0 && currentRow <= 8)
			{
				possible.add(cols[currentCol + 1] + String.valueOf(currentRow));
				if(currentRow + 1 <= 8)
					possible.add(cols[currentCol + 1] + String.valueOf(currentRow + 1));
				if(currentRow - 1 > 0)
					possible.add(cols[currentCol + 1] + String.valueOf(currentRow - 1));
			}
		}
		
		//Directly up
		if(currentRow + 1 <= 8)
			possible.add(cols[currentCol] + String.valueOf(currentRow + 1));
		if(currentRow - 1 > 0)
			possible.add(cols[currentCol] + String.valueOf(currentRow - 1));
		
		return possible;
	}
}
