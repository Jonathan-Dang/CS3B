import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * SalesRecord reads from disk formatted data and outputs total units sold from
 * each sector.
 * @author Jonathan Dang
 *
 */
public class SalesRecord {
	//Format: Name;Category;Units;MonthDayYear -> MMDDYYYY
	private ArrayList<Sale> _sales = new ArrayList<Sale>();
	private File _record;
	
	public SalesRecord(String filename)
	{
		_record = new File(filename);
		readFile();
	}
	
	/**
	 * Uses an indices matrix in order to calculate the total for all categories, then displays them to the console.
	 */
	public void displayTotalSales()
	{
		ArrayList<String> categories = new ArrayList<String>();
		ArrayList<ArrayList<Integer>> totals = new ArrayList<ArrayList<Integer>>();
		
		for(Sale s : _sales)
		{
			if (!categories.contains(s.getCategory()))
			{
				categories.add(s.getCategory());
			}
			
			int index = categories.indexOf(s.getCategory());
			
			if(index >= totals.size())
			{
				totals.add(new ArrayList<Integer>());
			}
			
			totals.get(index).add(s.getUnits());
		}
		
		ArrayList<Integer> finalTotals = new ArrayList<Integer>();
		
		for(int i = 0; i < totals.size(); i ++)
		{
			int sum = 0;
			for(int t : totals.get(i))
			{
				sum += t;
			}
			finalTotals.add(sum);
		}
		
		System.out.println("Totals from all collected Sales");
		for(int i = 0; i < categories.size(); i++)
		{
			System.out.println(categories.get(i) + ": " + finalTotals.get(i));
		}
	}
	
	/**
	 * Determines if the file is in valid format, then generates a list of sales dependent on the input.
	 */
	private void readFile()
	{
		try
		{
			Scanner ins = new Scanner(_record);
			
			while(ins.hasNext())
			{
				String line = ins.nextLine();
				if (!line.contains(";"))
				{
					throw new IllegalArgumentException("Incorrect Format!");
				}
				
				ArrayList<Integer> semi = new ArrayList<Integer>();

				for(int i = 0; i < line.length(); i++)
				{
					if(line.charAt(i) == ';')
						semi.add(i);
				}
				
				ArrayList<String> grouping = new ArrayList<String>();
				
				grouping.add(line.substring(0,semi.get(0))); //Name
				grouping.add(line.substring(semi.get(0) + 1,semi.get(1)).toUpperCase()); //Category
				grouping.add(line.substring(semi.get(1) + 1,semi.get(2))); //Unit
				grouping.add(line.substring(semi.get(2) + 1)); //Date
				
				int units = Integer.parseInt(grouping.get(2));
				int month = Integer.parseInt(grouping.get(3).substring(0, 2));
				int day = Integer.parseInt(grouping.get(3).substring(2, 4));
				int year = Integer.parseInt(grouping.get(3).substring(4));
				
				Sale s = new Sale(grouping.get(1), grouping.get(0), units, year, month, day);
				
				_sales.add(s);
			}
			
			ins.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("FILE NOT FOUND!");
			e.printStackTrace();
			return;
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
		
	}
}
