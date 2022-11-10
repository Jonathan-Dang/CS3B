package PP10_25;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

 /**
 A car shape that can be positioned anywhere on the screen.
 */
public class Car
{
	private int xLeft;
	private int yTop;
	private Color color;
	private int modifier;

	/**
	Constructs a car with a given top left corner.
	@param x the x-coordinate of the top-left corner
	@param y the y-coordinate of the top-left corner
	 */
	public Car(int x, int y)
	{
		xLeft = x;
		yTop = y;
		color = null;
		modifier = 1;
	}
	
	/**
	 * Constructs a car given a top left corner
	 * @param x = x-coordinate
	 * @param y = y-coordinate
	 * @param c = body color
	 * @param mod = size modifier
	 */
	public Car(int x, int y, Color c, int mod)
	{
		xLeft = x;
		yTop = y;
		color = c;
		modifier = mod;
	}
	
	/**
	 * Moves the Car by a certain amount
	 * @param dx - Change in x
	 * @param dy - Change in y
	 */
	public void translate(int dx, int dy)
	{
		xLeft += dx;
		yTop += dy;
	}

	/**
	Draws the car.
	@param g2 the graphics context
	 */
	public void draw(Graphics2D g2)
	{
		Rectangle body = new Rectangle(xLeft, yTop + 10*modifier, 60*modifier, 10*modifier);
		Ellipse2D.Double frontTire = new Ellipse2D.Double(xLeft + 10*modifier, yTop + 20*modifier, 10*modifier, 10*modifier);
		Ellipse2D.Double rearTire = new Ellipse2D.Double(xLeft + 40*modifier, yTop + 20*modifier, 10*modifier, 10*modifier);

		// The bottom of the front windshield
		Point2D.Double r1 = new Point2D.Double(xLeft + 10*modifier, yTop + 10*modifier);
		// The front of the roof
		Point2D.Double r2 = new Point2D.Double(xLeft + 20*modifier, yTop);
		// The rear of the roof
		Point2D.Double r3 = new Point2D.Double(xLeft + 40*modifier, yTop);
		// The bottom of the rear windshield
		Point2D.Double r4 = new Point2D.Double(xLeft + 50*modifier, yTop + 10*modifier);

		Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
		Line2D.Double roofTop = new Line2D.Double(r2, r3);
		Line2D.Double rearWindshield = new Line2D.Double(r3, r4);

		g2.setColor(color);
		g2.fill(body);
		g2.draw(body);
		//Tires
		g2.setColor(Color.black);
		g2.fill(frontTire);
		g2.fill(rearTire);
		g2.draw(frontTire);
		g2.draw(rearTire);

		g2.draw(frontWindshield);
		g2.draw(roofTop);
		g2.draw(rearWindshield);
	}
}