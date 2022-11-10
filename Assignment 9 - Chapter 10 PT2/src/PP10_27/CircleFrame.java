package PP10_27;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
/**
 * Circle Display Program marked for PP10.27
 * @author Jonathan Dang
 *
 */
public class CircleFrame extends JFrame{
	
	private double _radius = 1.5;
	private Shape _circle;
	
	/**
	 * Constructs the JFrame as a program that runs the Circle Program
	 */
	public CircleFrame()
	{
		MouseListener ML = new CircleActionListener();
		addMouseListener(ML);
		createCircle();
		
		setTitle("Drawing a Circle");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * Override for the Paint function
	 */
	@Override
	public void paint(Graphics g)
	{
		 Graphics2D g2d = (Graphics2D) g;

	     g2d.draw(_circle);
	}
	
	/**
	 * Constructs the Shape as a Circle with variable radius
	 */
	private void createCircle()
	{
		_circle = new Ellipse2D.Double(150,150,_radius*10,_radius*10);
	}
	
	/**
	 * Mouse Listener that controls where the mouse clicks
	 * If the mouse clicks within the circle then the radius is editable
	 * @author Jonathan Dang
	 *
	 */
	public class CircleActionListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(_circle.contains(getMousePosition()))
			{
				JFrame jf = new JFrame();
				double r = Double.parseDouble(JOptionPane.showInputDialog(jf, "Enter Radius"));
				if(r <= 0)
					throw new IllegalArgumentException("Invalid Radius");
				else
					_radius = r;
				
				Graphics g = getGraphics();
				g.clearRect(0, 0, (int)getSize().getWidth(), (int)getSize().getHeight());
				
				_circle = new Ellipse2D.Double(150, 150, _radius*10, _radius*10);
				repaint();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// Nothing
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// Nothing
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// Nothing
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// Nothing
			
		}
	}
}
