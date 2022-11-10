package PP10_25;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * Car Component meant to display 2 cars passing each other
 * @author Jonathan Dang
 *
 */
public class CarComponent extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7941068171101566516L;
	
	private Car _car;
	private Car _car2;
	
	/**
	 * Creates a Car Component in which 2 Cars exist
	 * @param x
	 * @param y
	 */
	public CarComponent(int x, int y)
	{
		_car = new Car(x,y);
		_car2 = new Car(x+225,y+50);
	}
	
	/**
	 * Moves all the cars within the component
	 * @param dx - change in x
	 * @param dy - change in y
	 */
	public void moveCar(int dx, int dy)
	{
		_car.translate(dx, dy);
		_car2.translate(-1*dx, dy);
		repaint();
	}
	
	/**
	 * Draws the component onto the JFrame
	 */
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		_car.draw(g2);
		_car2.draw(g2);
	}
}
