//Author: Jonathan Dang
//Project: Chapter 8 - 8.6
import java.util.ArrayList;

/**
 * The Table Class in which acts as a storage device using CSV
 * @author Jonathan Dang
 *
 */
public class Table {
	private ArrayList<ArrayList<String>> table;
	
	/**
	 * Default Constructor for the Table Object
	 */
	public Table()
	{
		table = new ArrayList<ArrayList<String>>();
	}
	
	/**
	 * Adds a string to the table.
	 * @param line
	 */
	public void addLine(String line)
	{
		String newLine = line;
		ArrayList<String> temp = new ArrayList<String>();
		int i = newLine.indexOf(',');
		
		while(i > 0)
		{
			String subs = newLine.substring(0,i);
			if(subs.contains("\""))
			{
				String subHolder = subs.substring(1, subs.length()-1);
				subHolder = subHolder.replaceAll("\"", "\"\"");
				subs = "\"" + subHolder + "\"";
			}
			
			temp.add(subs);
			newLine = newLine.substring(i + 1, newLine.length());
			i = newLine.indexOf(',');
			if(newLine.length() != 0 && !newLine.contains(","))
			{
				temp.add(newLine);
			}
		}
		table.add(temp);
	}
	
	/**
	 * Obtains a String object at the specified location.
	 * Out of bounds entries will return an empty string.
	 * @param row
	 * @param column
	 * @return String
	 */
	public String getEntry(int row, int column)
	{
		if(row > table.size() || column > table.get(row - 1).size())
			return "";
		
		return table.get(row - 1).get(column - 1);
	}
	
	/**
	 * Returns the amount of rows within the entire table
	 * @return rows
	 */
	public int rows()
	{
		return table.size();
	}
	
	/**
	 * Returns the amount of columns within the entire table
	 * @return columns
	 */
	public int columns()
	{
		int cols = 0;
		for(int i = 0; i < table.size();i++)
		{
			cols += table.get(i).size();
		}
		return cols;
	}
}