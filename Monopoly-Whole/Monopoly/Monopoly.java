package Monopoly;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Helpers.SaveLoader;

/**
 * Monopoly the Game!
 * I Do not take Ownership of Monopoly(tm), However due to an assignment
 * I have recreated it into a simplistic form for Education Reasons
 * @author Jonathan Dang
 *
 */
@SuppressWarnings("serial")
public class Monopoly extends JFrame{
	private player[] _players;
	private Board b;
	private SaveLoader SL;
	
	private JButton go;
	private JButton sell;
	private JButton endTurn;
	private JTextArea turnInfo;
	
	private boolean Moved;
	
	/**
	 * Constructs a Monopoly Game
	 */
	public Monopoly()
	{
		setTitle("Monopoly");
		setSize(900,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUpScreen();
		setLocationRelativeTo(null);
		Moved = false;
		
		try {
			this.startUp();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}		
		
	}
	
	/**
	 * Starts up the game from Console
	 * @throws IOException | Checks if the File is there or not
	 * @throws InterruptedException | Checks if something Interupts the processing time
	 */
	public void startUp() throws IOException, InterruptedException
	{
		SL= new SaveLoader();
		SL.display();
		Scanner ins = new Scanner(System.in);
		ArrayList<player> players = new ArrayList<player>();
		int totalPlayer = 0;
		while (totalPlayer < 2 || totalPlayer > 8) {
			try {
				System.out.println("How many people are playing?");
				System.out.print("Players (2 - 8): ");
				totalPlayer = ins.nextInt();
			}
			catch(Exception e) {
				System.err.println("Error: Number too large.");
				continue;
			}
			if(totalPlayer > 8) {
				System.err.println("Error: Invalid player count.");
			}
		}
		
		for (int i = 0; i < totalPlayer; i++)
		{
			System.out.println("Player " + (i+1));
			System.out.println("What is your name: ");
			String name = ins.next();
			System.out.println("Please enter a series of numbers, this will be your Credit Card Number: ");
			String CCN = ins.next();
			for (int t = 0; t < player.FIGURES.length; t++)
			{
				System.out.println(t + " " + player.FIGURES[t]);
			}
			System.out.println("Please enter a number that corresponds to a game piece:");
			int piece = ins.nextInt();
			
			player p = new player(piece,name,CCN);
			players.add(p);
		}
		
		_players = new player[totalPlayer];
		
		int i = 0;
		for (player p : players)
		{
			_players[i] = p;
			i++;
		}
		
		b = new Board(_players);
		ins.close();
		setVisible(true);
		this.updateInfo();
		this.startGame();
	}
	
	/**
	 * Runs the Game
	 */
	public void startGame()
	{
		while(!b.hasWinner())
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.endGame();
	}
	
	/**
	 * Updates the TextArea in which displays the game details
	 */
	private void updateInfo()
	{
		//FORMAT:
		//Player: [NAME]
		//[LocationName]
		//[Balance]
		
		String info = "";
		
		info += "TURN: " + b.getCurrentTurnPlayer().getName() + "\n";
		info += "LOCATION: " + b.getLocationName() + "\n";
		info += "BALANCE: " + b.getCurrentTurnPlayer().getBalance() + "\n";
		
		turnInfo.setText(info);
	}
	
	/**
	 * Initializes the Screen
	 */
	private void setUpScreen()
	{
		go = new JButton("GO!");
		go.addActionListener(new GoButtonListener());
		sell = new JButton("Sell");
		sell.addActionListener(new SellButtonListener());
		endTurn = new JButton("End Turn");
		endTurn.addActionListener(new NextTurnButtonListener());
		
		turnInfo = new JTextArea();
		turnInfo.setAlignmentY(CENTER_ALIGNMENT);
		turnInfo.setAlignmentX(CENTER_ALIGNMENT);
		turnInfo.setEditable(false);
		
		JPanel control = new JPanel();
		control.setLayout(new GridLayout(1,3));
		
		JPanel BuySell = new JPanel();
		BuySell.setLayout(new GridLayout(2,1));
		
		BuySell.add(go);
		BuySell.add(sell);
		
		control.add(BuySell);
		control.add(turnInfo);
		control.add(endTurn);
		
		add(control);
	}
	
	/**
	 * Processes Go
	 */
	private class GoButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!Moved)
			{
				b.Go();
				Moved = true;
			}
				
			updateInfo();
		}
		
	}
	
	/**
	 * Processes into the Next Turn
	 */
	private class NextTurnButtonListener implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			b.nextTurn();
			Moved = false;
			updateInfo();
		}
		
	}
	
	/**
	 * Processes and Calculates the Selling Action
	 */
	private class SellButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				b.sell(b.getTurn(), false);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			updateInfo();
		}
		
	}
	
	/**
	 * Ends the game!
	 */
	public void endGame()
	{
		SL.save(b.getPlayerData());
		player p = b.getWinner();
		JFrame jf = new JFrame();
		JOptionPane.showMessageDialog(jf, p.getName() + " Has won the game! Balance: " + p.getBalance());
	}
}
