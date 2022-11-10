import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 * O object that is drawn for the 2nd player of TicTacToe
 * @author Jonathan Dang
 *
 */
public class O {
	private int _x_Coord;
	private int _y_Coord;
	private static final double RADIUS = 300;
	
	/**
	 * Constructs an O object
	 * @param x coordinate
	 * @param y coordinate
	 * Keep in mind that it is for the Upper Left corner
	 */
	public O(int x, int y)
	{
		_x_Coord = x;
		_y_Coord = y;
	}
	
	/**
	 * draws the O
	 * @param g2 | The Graphics
	 */
	public void draw(Graphics2D g2)
	{
		Ellipse2D.Double circle = new Ellipse2D.Double(_x_Coord, _y_Coord, RADIUS, RADIUS);
		g2.draw(circle);
	}
}
