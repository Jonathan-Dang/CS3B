package Helpers;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

/**
 * Frame in which sells a property from a given player's owned property
 * @author Jonathan Dang
 *
 */
@SuppressWarnings("serial")
public class SellingFrame extends JDialog{
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 150;
	private ArrayList<String> _names = new ArrayList<String>();
	private JComboBox<String> JCB;
	private JButton JB;
	private JTextField JT;
	private String selection = "";
	//JFrame -> JScrollPane -> JPanel -> JTextField
	//include JComboBox
	
	/**
	 * Constructs a SellingFrame
	 * @param names
	 */
	public SellingFrame(ArrayList<String> names)
	{
		_names.add("NOTHING");
		for (String s : names)
		{
			_names.add(s);
		}
		
		this.createFrame();
		
		setTitle("Sell a Property");
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setModal(true); //<- This is VERY important
		setVisible(true);
	}
	
	/**
	 * Private Class to select and dipose of the selling frame
	 * @author Jonathan Dang
	 *
	 */
	private class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			selection = (String) JCB.getSelectedItem();
			dispose();
		}
	}
	
	/**
	 * Returns the Selected Nam
	 * @return
	 */
	public String getSelection()
	{
		return selection;
	}
	
	/**
	 * Initializes the Frame
	 */
	private void createFrame()
	{
		JCB = new JComboBox<String>();
		for (String s : _names)
		{
			JCB.addItem(s);
			
		}
		JCB.setEditable(false);
		
		
		JB = new JButton("Confirm");
		JB.addActionListener(new ButtonActionListener());
		
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(2,1));
		
		jp.add(JCB);
		
		JT = new JTextField();
		JT.setText("Please Select a property to sell!");
		JT.setEditable(false);
		
		jp.add(JB);
		
		add(JT, BorderLayout.CENTER);
		add(jp, BorderLayout.SOUTH);
	}
}
