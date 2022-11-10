//Author: Jonathan Dang
//Project: PP 9.1
package PP9_1;
import java.util.ArrayList;

/**
 * Basic Bishop Chess Piece
 * @author Jonathan Dang
 *
 */
public class Bishop extends ChessPiece
{
	/**
	 * Constructor for Subclass Bishop
	 * @param Coords
	 * @param Player
	 */
	public Bishop(String Coords, String Player)
	{
		super(Coords,Player);
	}
	
	/**
	 * Override for canMoveTo()
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
		
		//two for loops
		int t = 1, k = 1;
		for(int i = currentCol; i < 8; i++)
		{
			if(i != currentCol)
			{
				if(currentRow + t > 0 && currentRow + t <= 8)
					possible.add(cols[i] + String.valueOf(currentRow + t));
				if(currentRow - k > 0 && currentRow - k <= 8)
					possible.add(cols[i] + String.valueOf(currentRow - k));
				t++;
				k++;
			}
				
		}
		t = 1;
		k = 1;
		for(int i = currentCol; i >= 0; i--)
		{
			if(i != currentCol)
			{
				if(currentRow + t > 0 && currentRow + t <= 8)
					possible.add(cols[i] + String.valueOf(currentRow + t));
				if(currentRow - k > 0 && currentRow - k <= 8)
					possible.add(cols[i] + String.valueOf(currentRow - k));
				t++;
				k++;
			}
		}
		
		return possible;
	}
}
