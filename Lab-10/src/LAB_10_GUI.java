//Author: Jonathan Dang and Zaojia Zhao
//Project: LAB 10 - Base
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class LAB_10_GUI extends JFrame{
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 300;
	
	private JMenuBar _menu;
	
	public LAB_10_GUI()
	{
		createMenu();
		setJMenuBar(_menu);
		
		setTitle("Lab 10");
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public class ExitActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	public class Problem5ActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			new CurrencyConversion();
		}
	}
	
	private void createMenu() 
	{
		_menu = new JMenuBar();
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ExitActionListener());
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(exitItem);
		
		JMenu problemMenu = new JMenu("Problems");
		JMenuItem PP20_5 = new JMenuItem("P20.5");
		PP20_5.addActionListener(new Problem5ActionListener());
		JMenuItem PP20_6 = new JMenuItem("P20.6");
		problemMenu.add(PP20_5);
		problemMenu.add(PP20_6);
		
		_menu.add(fileMenu);
		_menu.add(problemMenu);
	}
	
	public static void main(String[] arg)
	{
		new LAB_10_GUI();
	}
}
