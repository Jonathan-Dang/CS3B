package Helpers;

import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import Monopoly.player;

/**
 * SaveLoader Loads and Saves Player data to and from disk
 * @author Jonathan Dang
 *
 */
public class SaveLoader {
	private File _topScore;
	private File _previousScore;
	private final String TopScoreFileName = "TopScore.txt";
	private final String PreviousScoreFileName = "PreviousScore.txt";
	private ArrayList<ArrayList<String>> _topInfo = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> _prevInfo = new ArrayList<ArrayList<String>>();
	
	/* Previous Game!
	 * FORMAT:[playerName] [CreditCardNumber] [balance] \n
	 */
	
	/* Top 6
	 * FORMAT:[Place] [playerName] [CCN] [Balance] \n
	 */
	
	/**
	 * Constructs a SaveLoader
	 * @throws IOException
	 */
	public SaveLoader() throws IOException
	{
		_topScore = new File(TopScoreFileName);
		_previousScore = new File(PreviousScoreFileName);
		
		if (_topScore.createNewFile())
		{
			System.out.println("TOP SCORE: NO FILE DETECTED!\nCREATING NEW FILE...");
		}
		
		if (_previousScore.createNewFile())
		{
			System.out.println("PREVIOUS SCORE: NO FILE DETECTED!\nCREATING NEW FILE...");
		}
		
		this.load();
	}
	
	/**
	 * Displays the leaderBoard
	 */
	public void display()
	{
		JFrame leaderBoard = new JFrame();
		leaderBoard.setTitle("Leader Board");
		leaderBoard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		leaderBoard.setSize(600, 300);
		
		JTextArea prev = new JTextArea();
		prev.setEditable(false);
		JTextArea top = new JTextArea();
		top.setEditable(false);
		
		String prevMessage = "";
		for (ArrayList<String> as : _prevInfo)
		{
			prevMessage += String.format("%-" + ((int)as.get(0).length()+5) + "s%" + ((int)as.get(1).length() + 5) 
					+ "s%" + ((int)as.get(2).length() + 5) + "s%n%n"
					, as.get(0),as.get(1),as.get(2));
		}
		
		if (prevMessage.isBlank())
		{
			prev.setText("NONE YET!");
		}
		else
			prev.setText(prevMessage);
		
		String topMessage = "";
		for (ArrayList<String> as : _topInfo)
		{
			topMessage += String.format("%-3s)%" + ((int)as.get(1).length()+5) + "s%" 
					+ ((int)as.get(2).length() + 5) + "s%10s%n%n"
					, as.get(0),as.get(1),as.get(2),as.get(3));
		}
		if (topMessage.isBlank())
			top.setText("NO TOP SCORES YET");
		else
			top.setText(topMessage);
		
		JPanel JP = new JPanel();
		JP.setLayout(new GridLayout(1,3));
		Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		prev.setBorder(raisedetched);
		top.setBorder(raisedetched);
		
		JP.add(prev);
		JP.add(new JPanel());
		JP.add(top);
		
		leaderBoard.add(JP);
		leaderBoard.setVisible(true);
	}
	
	/**
	 * Saves a list of players to disk and compares them to the top 6 of all times
	 * @param a | player List
	 */
	public void save(ArrayList<player> a)
	{
		ArrayList<String> record = new ArrayList<String>();
		for (player p : a)
		{
			String playerInfo = p.getName() + " " + p.getCCN() + " " + p.getBalance();
			record.add(playerInfo);	
		}
		
		try {
			if (_previousScore.exists())
			{
				_previousScore.delete();
				_previousScore.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {};
		
		try {
			PrintWriter PW = new PrintWriter(_previousScore);
			for (String s : record)
			{
				PW.println(s);
			}
			
			PW.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {};
		
		//Now I need to compare all the values from the Top 6 and re-distribute the values
		//IE: Replace Inferior Scores!
		//Solution: We first make a copy with Top6 on top and then all player balances.
		//We compare them after sorting to find the indexes, anything past index 5 is in players.
		//Remake the Top 6 and save to disk
		
		player[] playersTop = new player[6 + a.size()];
		int i = 0;
		for (player p : a)
		{
			playersTop[i++] = p;
			//i++;
		}
		
		if (_topInfo.isEmpty())
		{
			for (int j = 0; j < 6; j++)
			{
				player p = new player(-1,"NONE","NONE");
				p.manipulateMoney(-1300);
				playersTop[i++] = p;
			}
		}
		else
		{
			for (ArrayList<String> info : _topInfo)
			{
				player p = new player(-1, info.get(1), info.get(2));
				p.manipulateMoney(-1300);
				p.manipulateMoney(Integer.parseInt(info.get(info.size()-1)));
				playersTop[i++] = p;
			}
		}
		
		
		
		sort(playersTop,0,playersTop.length-1);
		
		try {
			if (_topScore.exists())
			{
				_topScore.delete();
				_topScore.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {};
		
		ArrayList<String> topScores = new ArrayList<String>();
		int t = 1;
		for (i = playersTop.length - 1; i > playersTop.length - 7; i--)
		{
			
			String playerInfo = t++ + " " + playersTop[i].getName() + " " + playersTop[i].getCCN() + " " + playersTop[i].getBalance();
			topScores.add(playerInfo);
		}
		try {
			PrintWriter PW = new PrintWriter(_topScore);
			for (String s : topScores)
			{
				PW.println(s);
			}
			PW.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {};
		
		
		
		//Most likely we have to sort it anyway... Maybe its easier to make something that sorts the entire thing.
	}
	
	/**
	 * Sorting Algorithm
	 * @param a Array
	 * @param low lowest index
	 * @param high highest index
	 */
	private static void sort(player[] a, int low, int high)
	{
		if (low < high)
	    {
	        int pi = partition(a, low, high);

	        sort(a, low, pi - 1);
	        sort(a, pi + 1, high);
	    }
	}
	
	/**
	 * Checks the Low and high and swaps it upon certain conditions
	 * @param a Array
	 * @param low lowest Index
	 * @param high highest Index
	 * @return
	 */
	private static int partition(player[] a, int low, int high)
	{
	    player pivot = a[high];
	    int i = (low - 1);
	 
	    for(int j = low; j <= high - 1; j++)
	    {
	        if (a[j].getBalance() < pivot.getBalance())
	        {
	            i++;
	            swap(a, i, j);
	        }
	    }
	    swap(a, i + 1, high);
	    return (i + 1);
	}
	
	/**
	 * Swaps two data types between each other on the array
	 * @param a The Array
	 * @param i 1st Index
	 * @param j 2nd Index
	 */
	private static void swap(player[] a, int i, int j)
	{
	    player temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
	
	/**
	 * Loads the data from Disk
	 */
	public void load()
	{
		try {
			Scanner topIns = new Scanner(_topScore);
			Scanner prevIns = new Scanner(_previousScore);
			
			while (topIns.hasNextLine())
			{
				String input = topIns.nextLine();
				ArrayList<String> row = new ArrayList<String>();
				
				while (!input.isBlank())
				{
					int i = input.indexOf(" ");
					
					if (i < 0)
					{
						input.strip();
						row.add(input);
						break;
					}
					
					String info = input.substring(0, i);
					input = input.substring(i + 1);
					info.strip();
					row.add(info);
				}
				_topInfo.add(row);
			}
			
			while (prevIns.hasNextLine())
			{
				String input = prevIns.nextLine();
				ArrayList<String> row = new ArrayList<String>();
				
				while (!input.isBlank())
				{
					int i = input.indexOf(" ");
					
					if (i < 0)
					{
						input.strip();
						row.add(input);
						break;
					}
					
					String info = input.substring(0, i);
					input = input.substring(i + 1);
					info.strip();
					row.add(info);
				}
				_prevInfo.add(row);
			}
			
			topIns.close();
			prevIns.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
