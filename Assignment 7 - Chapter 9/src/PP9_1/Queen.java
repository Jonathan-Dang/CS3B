//Author: Jonathan Dang
//Project: PP 9.1
package PP9_1;
import java.util.ArrayList;

/**
 * Basic Queen Chess Piece
 * @author pocke
 *
 */
public class Queen extends ChessPiece
{
	/**
	 * Constructs subclass Queen
	 * @param Coords
	 * @param Player
	 */
	public Queen(String Coords, String Player)
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
		
		//Bishop Algorithm
		///////////////////////////////////////////////////////////////////
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
		
		//Rook Algorithm
		////////////////////////////////////////////////////////////////////////
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
