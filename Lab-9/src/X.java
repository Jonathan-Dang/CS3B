import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * X object drawn for player 1 in TicTacToe
 * @author Jonathan Dang
 *
 */
public class X {
	private static final int SIZE = 300;
	//Coordinates for Upper-Left Corner
	private int _x_Coord;
	private int _y_Coord;
	
	/**
	 * Contructs an X object
	 * @param x coordinate
	 * @param y coordinate
	 * Keep in mind that the coordinates are for the upper left hand corner
	 */
	public X(int x, int y)
	{
		_x_Coord = x;
		_y_Coord = y;
	}
	
	/**
	 * Draws the X
	 * @param g2 | The Graphics
	 */
	public void draw(Graphics2D g2)
	{
		Point2D.Double UL = new Point2D.Double(_x_Coord,_y_Coord);
		Point2D.Double LR = new Point2D.Double(_x_Coord + SIZE,_y_Coord + SIZE);
		Line2D.Double negativeXLine = new Line2D.Double(UL,LR);
		
		Point2D.Double UR = new Point2D.Double(_x_Coord + SIZE, _y_Coord);
		Point2D.Double LL = new Point2D.Double(_x_Coord, _y_Coord + SIZE);
		Line2D.Double positiveXLine = new Line2D.Double(UR, LL);
		
		g2.draw(positiveXLine);
		g2.draw(negativeXLine);
	}
}
