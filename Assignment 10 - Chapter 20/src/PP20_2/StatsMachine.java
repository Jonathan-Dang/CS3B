package PP20_2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
/**
 * Stats Machine
 * @author Jonathan Dang
 *
 */
public class StatsMachine extends JFrame{
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 100;
	
	private static final String DEFAULT_STRING_AVERAGE = "Average: ";
	private static final String DEFAULT_STRING_MAX = "Max: ";
	private static final String DEFAULT_STRING_MIN = "Min: ";
	
	private JButton _entryButton;
	private JTextField _entrySpace;
	private JLabel _averageDisplay;
	private JLabel _maxDisplay;
	private JLabel _minDisplay;
	
	private ArrayList<Float> _dataSet = new ArrayList<Float>();
	private float _max;
	
	/**
	 * Generates a JFrame to allow for the Stats Machine to Run
	 */
	public StatsMachine()
	{
		JPanel statsMachine = new JPanel();
		statsMachine.add(createEntryPanel());
		statsMachine.add(createStatsPanel());
		add(statsMachine,BorderLayout.CENTER);
		
		setTitle("Stats Machine");
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * Internal Action Listener for the Entry Button
	 * @author Jonathan Dang
	 *
	 */
	public class EntryButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(_entrySpace.getText().isEmpty())
				return;
			float _entry = Float.parseFloat(_entrySpace.getText());
			_dataSet.add(_entry);
			
			//Average
			float average = 0;
			for(float i : _dataSet)
			{
				average += i;
			}
			average /= _dataSet.size();
			_averageDisplay.setText(DEFAULT_STRING_AVERAGE + average);
			
			//Max
			if(_entry > _max)
				_max = _entry;
			_maxDisplay.setText(DEFAULT_STRING_MAX + _max);
			
			//Minimum
			float min = _entry;
			for(float i : _dataSet)
			{
				if(min > i)
					min = i;
			}
			_minDisplay.setText(DEFAULT_STRING_MIN + min);
			_entrySpace.setText("");
			repaint();
		}
	}
	
	/**
	 * Constructs a panel that displays the average, min and max of the given data set
	 * @returns JPanel with 3 JLabels
	 */
	private JPanel createStatsPanel()
	{
		JPanel jp = new JPanel();
		
		_averageDisplay = new JLabel(DEFAULT_STRING_AVERAGE + "0");
		_maxDisplay = new JLabel(DEFAULT_STRING_MAX + "0");
		_minDisplay = new JLabel(DEFAULT_STRING_MIN + "0");
		jp.setLayout(new GridLayout(3,1));
		jp.add(_averageDisplay);
		jp.add(_maxDisplay);
		jp.add(_minDisplay);
		
		jp.setBorder(new EtchedBorder());
		
		return jp;
	}
	
	/**
	 * Constructs a panel that allows for User input from the JFrame
	 * @returns JPanel with 1 JButton and 1 JTextField
	 */
	private JPanel createEntryPanel()
	{
		JPanel jp = new JPanel();
		
		_entryButton = new JButton("Submit Number");
		_entryButton.addActionListener(new EntryButtonListener());
		_entrySpace = new JTextField(10);
		_entrySpace.setText("Enter Number Here");
		jp.add(_entrySpace);
		jp.add(_entryButton);

		jp.setBorder(new EtchedBorder());
		
		return jp;
	}
}
