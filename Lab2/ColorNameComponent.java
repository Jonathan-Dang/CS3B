//Please View ColorNameViewer for all nesessary Comments

import javax.swing.JComponent;
import java.awt.*;

public class ColorNameComponent extends JComponent
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//
	
	public void paintComponent(Graphics g)
	{
		//Graphics to Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		//Initializing the color to string arrays
		Color set[] = {Color.BLACK,Color.BLUE,Color.CYAN,Color.GRAY
				,Color.GREEN,Color.MAGENTA, Color.ORANGE, Color.RED,
				Color.YELLOW,Color.DARK_GRAY,Color.PINK,Color.LIGHT_GRAY}; 
		String textSet[] = {"Black","Blue","Cyan","Gray","Green","Magenta"
				,"Orange","Red","Yellow","Dark Gray","Pink","Light Gray"};
		
		//For loop to go through the arrays
		for(int i = 0; i < 12; i++)
		{
			g2.setColor(set[i]);
			g2.drawString(textSet[i], 0, (i+1)*20);
		}
	}
}
