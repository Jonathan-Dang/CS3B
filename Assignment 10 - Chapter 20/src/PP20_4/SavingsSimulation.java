package PP20_4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
/**
 * Savings Account Simulation with PP20.4 Modifications to PP20.3
 * @author Jonathan Dang
 *
 */
public class SavingsSimulation extends JFrame{
	private static final int FRAME_WIDTH = 900;
	private static final int FRAME_HEIGHT = 600;
	private static final int FIELD_WIDTH = 10;
	
	private JTextField _yearsField = new JTextField(FIELD_WIDTH);
	private JTextField _initialAmountField = new JTextField(FIELD_WIDTH);
	private JTextField _rateField = new JTextField(FIELD_WIDTH);
	private JButton _enterData;
	
	private JTextArea _simulationArea = new JTextArea(FIELD_WIDTH * 2, FIELD_WIDTH * 2);
	
	/**
	 * Generates a JFrame in which displays the Savings Simulation can be conducted
	 */
	public SavingsSimulation()
	{
		createButton();
		createTextFields();
		
		add(createEntryPanel(),BorderLayout.CENTER);
		
		setTitle("Stats Machine");
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * Action Listener to controls the entry of data for the simulation
	 * @author Jonathan Dang
	 *
	 */
	public class EntryActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(_yearsField.getText().isEmpty() || _initialAmountField.getText().isEmpty() || _rateField.getText().isEmpty())
				return;
			double rate = Double.parseDouble(_rateField.getText());
			double years = Double.parseDouble(_yearsField.getText());
			double bal = Double.parseDouble(_initialAmountField.getText());
			
			String output = "Initial Value: $" + bal + "| Every * is $500" + "\n";
			for(double i = 0; i < years; i++)
			{
				bal += bal*rate;
				output += "Year: " + ((int) i + 1) + "| Bal: ";
				for(int t = 0; t < bal/500; t++)
				{
					output += "*";
				}
				output += "\n";
			}
			
			_simulationArea.setText(output);
			repaint();
		}
	}
	
	/**
	 * Initializes the button
	 */
	private void createButton()
	{
		_enterData = new JButton("Submit Simulation Data");
		_enterData.addActionListener(new EntryActionListener());
	}
	
	/**
	 * Initializes the TextFields
	 */
	private void createTextFields()
	{
		_yearsField.setText("Enter Length of time Here in years");
		_initialAmountField.setText("Enter your Inital Savings Balance here");
		_rateField.setText("Enter Rate Here | EX: 0.05");
		
		_simulationArea.setText("");
		_simulationArea.setEditable(false);
	}
	
	/**
	 * Formats and creates the Entry Panel
	 * @returns a Panel with 4 Text Fields and 1 Button
	 */
	private JPanel createEntryPanel()
	{
		JPanel jp = new JPanel();
		
		JPanel entries = new JPanel();
		entries.setLayout(new GridLayout(3,1));
		entries.add(_initialAmountField);
		entries.add(_rateField);
		entries.add(_yearsField);
		
		jp.setLayout(new GridLayout(1,3));
		jp.add(entries);
		jp.add(_enterData);
		jp.add(_simulationArea);
		
		return jp;
	}
}
