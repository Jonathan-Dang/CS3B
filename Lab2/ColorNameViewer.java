//Dang, Jonathan
//Lab 2, 2-15
//File takes no input and outputs a small frame that displays 12 colored texts as
//requested from the programming project 2-15
import javax.swing.*;

public class ColorNameViewer 
{
	public static void main(String[] arg)
	{
		//Initialize the Frame
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		frame.setTitle("Lab 2 | 2.15");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Call the Color Component and Add it to frame
		ColorNameComponent c = new ColorNameComponent();
		frame.add(c);
		frame.setVisible(true);
	}
}

//The Sample Output cannot be displayed because it is a graphic.