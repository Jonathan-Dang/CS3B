//Author: Jonathan Dang and Zaojia Zhao
//Project: PP20.5
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
/**
 * Problem PP20.5, Currency Conversion Simulation
 * @author Jonathan Dang
 *
 */
public class CurrencyConversion extends JFrame{
	//USD 1.42 = GBP 1 = EUR 1.13
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 300;
	private static final String USD = "USD";
	private static final String GBP = "GBP";
	private static final String EUR = "EUR";
	private static final NumberFormat formatter = new DecimalFormat("#0.00");  
	
	private JTextField _leftSideEntry = new JTextField(10);
	private JTextField _rightSideResult = new JTextField(10);
	
	private JButton _entryButton = new JButton("Enter");
	
	private JComboBox<String> _leftSideConversion;
	private JComboBox<String> _rightSideConversion;
	
	/**
	 * Constructs and Generates a new JFrame that is close-able w/o exiting the entire program
	 * that can convert 3 types of currency between each other
	 */
	public CurrencyConversion()
	{
		createComboBoxes();
		
		JPanel converter = new JPanel();
		converter.setLayout(new GridLayout(1,3));
		converter.add(createEntryPanelLeft());
		_entryButton.addActionListener(new ComboBoxesListener());
		converter.add(_entryButton);
		converter.add(createPanelRight());
		
		add(converter,BorderLayout.CENTER);
		
		setTitle("Lab 10");
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	/**
	 * Creates a JPanel in which User input can be taken
	 * @returns a JPanel with 1 TextField and 1 ComboBox
	 */
	private JPanel createEntryPanelLeft()
	{
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(2,1));
		
		jp.add(_leftSideEntry);
		jp.add(_leftSideConversion);
		
		return jp;
	}
	
	/**
	 * Creates a JPanel in which displays the converted 
	 * Currency along with a Combobox
	 * @returns a JPanel with 1 TextField and 1 ComboBox
	 */
	private JPanel createPanelRight()
	{
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(2,1));
		
		_rightSideResult.setEditable(false);
		
		jp.add(_rightSideResult);
		jp.add(_rightSideConversion);
		
		return jp;
	}
	
	/**
	 * Action Listener that Performs all calculations between
	 * currency conversions
	 * @author Jonathan Dang
	 *
	 */
	private class ComboBoxesListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			String left = (String) _leftSideConversion.getSelectedItem();
			String right = (String) _rightSideConversion.getSelectedItem();
			
			if(_leftSideEntry.getText().isEmpty())
				return;
			
			if(left.equals(right))
			{
				JFrame f = new JFrame();  
			    JOptionPane.showMessageDialog(f,"Do not set both conversions to the same thing.","Alert",JOptionPane.WARNING_MESSAGE);
			    return;
			}
			
			double leftRate = 0, rightRate = 0 , leftConvert = Double.parseDouble(_leftSideEntry.getText()), rightResult = 0;
			
			if(left.equals(USD))
			{
				leftRate = 1.64;
			}
			else if(left.equals(EUR))
			{
				leftRate = 1.13;
			}
			else if(left.equals(GBP))
			{
				leftRate = 1;
			}
			
			if(right.equals(USD))
			{
				rightRate = 1.64;
			}
			else if(right.equals(EUR))
			{
				rightRate = 1.13;
			}
			else if(right.equals(GBP))
			{
				rightRate = 1;
			}
			
			if(!right.equals(GBP))
			{
				if(!left.equals(GBP))
				{
					rightResult = rightRate * ((double) leftConvert / leftRate);
				}
				else
				{
					rightResult = (double) leftConvert * rightRate;
				}
			}
			else
			{
				rightResult = (double) leftConvert/leftRate;
			}
			
			_rightSideResult.setText(formatter.format(rightResult));
			repaint();
		}
	}
	
	/**
	 * Creates the ComboBoxs that allow for selective Currency Conversion
	 */
	private void createComboBoxes()
	{
		_leftSideConversion = new JComboBox<String>();
		_rightSideConversion = new JComboBox<String>();
		
		_leftSideConversion.addItem("GBP");
		_leftSideConversion.addItem("USD");
		_leftSideConversion.addItem("EUR");
		_leftSideConversion.setEditable(true);
		
		_rightSideConversion.addItem("USD");
		_rightSideConversion.addItem("GBP");
		_rightSideConversion.addItem("EUR");
		_rightSideConversion.setEditable(true);
	}
}
