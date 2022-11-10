package PP10_25;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
/**
 * MovingCar object that displays the animation as a JFrame
 * @author Jonathan Dang
 *
 */
public class MovingCars extends JFrame{
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;
	
	private CarComponent _car;
	
	/**
	 * Action Listener that Controls the movement of the cars through a timer
	 * @author Jonathan Dang
	 *
	 */
	public class TimerListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			_car.moveCar(1, 0);
		}
	}
	
	/**
	 * Constructs the JFrame extension and sets a timer
	 */
	public MovingCars()
	{
		_car = new CarComponent(0, 10);
		add(_car);
		
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		
		ActionListener AL = new TimerListener();
		Timer t = new Timer(50,AL);
		t.start();
	}
}
