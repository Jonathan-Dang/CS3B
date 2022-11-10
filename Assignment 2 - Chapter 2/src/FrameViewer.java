//Author: Dang, Jonathan
//Project: Frame Viewer | Project 2.16
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.net.MalformedURLException; 
public class FrameViewer
{
	public static void main(String[] args) throws MalformedURLException
	{
		//Initialize objects
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		JLabel label = new JLabel("Hello, Jonathan!");
		frame.setTitle("Frame Viewer Programing Project");
		
		//Frame Color
		label.setOpaque(true);
		label.setBackground(Color.decode("#90ee90"));
		
		//Frame Label
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Activate Frame
		frame.setVisible(true);
	}
}
//Sample Run Unavailable due to it being a Frame output