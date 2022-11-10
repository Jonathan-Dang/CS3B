//Author: Jonathan Dang
//Project: PP 9.1
package PP9_1;
import java.util.ArrayList;

/**
 * Knight Chess Piece
 * @author Jonathan Dang
 *
 */
public class Knight extends ChessPiece
{
	/**
	 * Basic Constructor for SubClass Knight
	 * @param coordinates
	 * @param Player
	 */
	public Knight(String coordinates, String Player)
	{
		super(coordinates,Player);
	}
	
	/**
	 * Overload for canMoveTo()
	 * @returns all possible moves
	 */
	public ArrayList<String> canMoveTo()
	{
		if(!super.isValidPosition())
			return null;
		ArrayList<String> possible = new ArrayList<String>();
		//Checks for Possible Moves Outside Boundary
		//Only Proves true if it is out of bounds

		int currentRow = Integer.parseInt(getCoords().substring(1));
		int centerSection = 0;
		for(int i = 0; i < 8; i++)
		{
			if(Character.compare(getCoords().charAt(0),cols[i]) != 0)
			{
				centerSection++;
			}
			else
				break;
		}
		//Top Series
		if(currentRow + 2 <= 8)
		{
			if(centerSection - 2 >= 0)
			{
				//Top Left Series
				possible.add(cols[centerSection - 2] + String.valueOf(currentRow + 1));
				possible.add(cols[centerSection - 1] + String.valueOf(currentRow + 2));
			}
			else if (centerSection - 1 >= 0)
			{
				//Half
				possible.add(cols[centerSection - 1] + String.valueOf(currentRow + 2));
			}
			
			if(centerSection + 2 <= 8)
			{
				//Top Right Series
				possible.add(cols[centerSection + 2] + String.valueOf(currentRow + 1));
				possible.add(cols[centerSection + 1] + String.valueOf(currentRow + 2));
			}
			else if(centerSection + 1 <= 8)
			{
				//Half
				possible.add(cols[centerSection + 1] + String.valueOf(currentRow + 2));
			}
		}
		else if(currentRow + 1 <= 8)
		{
			if(centerSection - 2 > 0)
			{
				//Top Left Series
				possible.add(cols[centerSection - 2] + String.valueOf(currentRow + 1));
			}
			
			if(centerSection + 2 <= 8)
			{
				//Top Right Series
				possible.add(cols[centerSection + 2] + String.valueOf(currentRow + 1));
			}
		}
		
		//Bottom Series
		if(currentRow - 2 >= 0)
		{
			if(centerSection - 2 >= 0)
			{
				//Top Left Series
				possible.add(cols[centerSection - 2] + String.valueOf(currentRow - 1));
				possible.add(cols[centerSection - 1] + String.valueOf(currentRow - 2));
			}
			else if (centerSection - 1 >= 0)
			{
				//Half
				possible.add(cols[centerSection - 1] + String.valueOf(currentRow - 2));
			}
			
			if(centerSection + 2 <= 8)
			{
				//Top Right Series
				possible.add(cols[centerSection + 2] + String.valueOf(currentRow - 1));
				possible.add(cols[centerSection + 1] + String.valueOf(currentRow - 2));
			}
			else if(centerSection + 1 <= 8)
			{
				//Half
				possible.add(cols[centerSection + 1] + String.valueOf(currentRow - 2));
			}
		}
		else if(currentRow - 1 > 0)
		{
			if(centerSection - 2 > 0)
			{
				//Top Left Series
				possible.add(cols[centerSection - 2] + String.valueOf(currentRow - 1));
			}
			
			if(centerSection + 2 <= 8)
			{
				//Top Right Series
				possible.add(cols[centerSection + 2] + String.valueOf(currentRow - 1));
			}
		}
		
		
		return possible;
	}
}
