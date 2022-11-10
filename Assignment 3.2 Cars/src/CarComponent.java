import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
public class CarComponent extends JComponent 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Car car1 = new Car(0,0,Color.YELLOW,1);
		Car car2 = new Car(60,0,Color.RED,1);
		Car car3 = new Car(120,0,Color.WHITE,1);
		Car car4 = new Car(30,40,null,2);
		
		car1.draw(g2);
		car2.draw(g2);
		car3.draw(g2);
		car4.draw(g2);
	}
}
