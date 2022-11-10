//Author: Jonathan Dang
//Project: Cars
/*
 * This program shows the implementation of the car object as a class that is draw in the
 * JFrame. 
 */
import javax.swing.JFrame;
import java.awt.Color;
public class CarViewer {
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		
		frame.setSize(300, 400);
		frame.setBackground(Color.DARK_GRAY);
		frame.setTitle("Two Cars");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CarComponent component = new CarComponent();
		frame.add(component);
		
		frame.setVisible(true);
	}
}
//No Sample Run due to it being a window