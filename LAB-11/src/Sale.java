import java.util.Date;

/**
 * Sale object that keeps track of where it was, the date, and their name
 * @author Jonathan Dang
 *
 */
public class Sale {
	private String _name;
	private int _unit;
	private String _category;
	private Date _date;
	
	@SuppressWarnings("deprecation")
	public Sale(String cat, String name, int unit, int year, int month, int day)
	{
		_name = name;
		_category = cat;
		_unit = unit;
		_date = new Date(year - 1900, month, day);
	}
	
	public String getName()
	{
		return _name;
	}
	
	public String getCategory()
	{
		return _category;
	}
	
	public int getUnits()
	{
		return _unit;
	}
	
	public Date getDate()
	{
		return _date;
	}
}
