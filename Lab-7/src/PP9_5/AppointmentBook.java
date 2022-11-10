//Author: Jonathan Dang
//Project: PP9.5
package PP9_5;
import java.util.ArrayList;
import java.util.Date;

import problem4.Appointment;
import problem4.Daily;
import problem4.Monthly;
import problem4.Onetime;

/**
 * An Appointment Book to keep track of all appointments
 * @author Jonathan Dang
 *
 */
public class AppointmentBook {
	private ArrayList<Daily> _daily;
	private ArrayList<Monthly> _monthly;
	private ArrayList<Onetime> _onetime;
	private static String[] months = {"Jan" ,"Feb" ,"Mar" ,"Apr" ,"May" ,"Jun" ,"Jul" ,"Aug" ,"Sept" ,"Oct" ,"Nov" ,"Dec"};
	private static String[] day = {"Mon" ,"Tues" ,"Wed" ,"Thurs" ,"Fri" ,"Sat" ,"Sun"};
	
	/**
	 * Constructs an Appointment Book Object
	 */
	public AppointmentBook()
	{
		_daily = new ArrayList<Daily>();
		_monthly = new ArrayList<Monthly>();
		_onetime = new ArrayList<Onetime>();
	}
	
	/**
	 * Returns a copy of all Daily appointments
	 * @return Daily Appointments
	 */
	public ArrayList<Daily> getDaily()
	{
		ArrayList<Daily> ret = new ArrayList<Daily>();
		for(int i = 0; i < _daily.size();i++)
		{
			ret.add(_daily.get(i));
		}
		return ret;
	}
	
	/**
	 * Returns a copy of all Monthly Appointments
	 * @return Monthly Appointments
	 */
	public ArrayList<Monthly> getMonthly()
	{
		ArrayList<Monthly> ret = new ArrayList<Monthly>();
		for(int i = 0; i < _monthly.size(); i++)
		{
			ret.add(_monthly.get(i));
		}
		return ret;
	}
	
	/**
	 * Returns a copy of all One Time Appointments
	 * @return One Time Appointments
	 */
	public ArrayList<Onetime> getOneTime()
	{
		ArrayList<Onetime> ret = new ArrayList<Onetime>();
		for(int i = 0; i < _onetime.size(); i++)
		{
			ret.add(_onetime.get(i));
		}
		return ret;
	}
	
	/**
	 * Removes an appointment from the book
	 * @param type of appointment
	 * @param description of the appointment
	 * @param year of the appointment
	 * @param month of the appointment
	 * @param day of the appointment
	 */
	public void removeAppointment(String type, String description, int year, int month, int day)
	{
		String upper = type.toUpperCase();
		upper = upper.replace(" ", "");
		@SuppressWarnings("deprecation")
		Date _d = new Date(year,month - 1,day);
		
		if(upper.compareTo("DAILY") == 0)
		{
			for(int i = 0; i < _daily.size(); i++)
			{
				if(_daily.get(i).getDate().compareTo(_d) == 0 &&
						_daily.get(i).getDescription().contains(description))
				{
					_daily.remove(i);
					break;
				}
			}
		}
		else if(upper.compareTo("MONTHLY") == 0)
		{
			for(int i = 0; i < _monthly.size(); i++)
			{
				if(_monthly.get(i).getDate().compareTo(_d) == 0 &&
						_monthly.get(i).getDescription().contains(description))
				{
					_monthly.remove(i);
					break;
				}
			}
		}
		else if(upper.compareTo("ONETIME") == 0)
		{
			for(int i = 0; i < _onetime.size(); i++)
			{
				if(_onetime.get(i).getDate().compareTo(_d) == 0 &&
						_onetime.get(i).getDescription().contains(description))
				{
					_onetime.remove(i);
					break;
				}
			}
		}
		else
			throw new IllegalArgumentException("Invalid Appointment Type!");
	}
	
	/**
	 * Adds an appointment to the book
	 * @param The type of appointment
	 * @param description of the appointment
	 * @param day
	 * @param month
	 * @param year
	 */
	public void addAppointment(String type, String description, int day, int month, int year)
	{
		String upper = type.toUpperCase();
		upper = upper.replace(" ", "");
		Daily _d = null;
		Monthly _m = null;
		Onetime _o = null;
		
		if(upper.compareTo("DAILY") == 0)
		{
			_d = new Daily(year, month, day, description);
		}
		else if(upper.compareTo("MONTHLY") == 0)
		{
			_m = new Monthly(year, month, day, description);
		}
		else if(upper.compareTo("ONETIME") == 0)
		{
			_o = new Onetime(year, month, day, description);
		}
		else
			throw new IllegalArgumentException("Invalid Appointment Type!");
		
		if(_d != null)
		{
			_daily.add(_d);
		}
		else if(_m != null)
		{
			_monthly.add(_m);
		}
		else if(_o != null)
		{
			_onetime.add(_o);
		}
	}
	
	/**
	 * Checks if there is any appointments on the specified date
	 * @param year
	 * @param month
	 * @param day
	 * @returns all appointments on that specific day
	 */
	public ArrayList<Appointment> getAppointments(int year, int month, int day)
	{
		ArrayList<Appointment> todaysTask = new ArrayList<Appointment>();
		
		for(int i = 0; i < _daily.size(); i++)
		{
			if(_daily.get(i).occursOn(year, month, day))
			{
				todaysTask.add(_daily.get(i));
			}
		}
		for(int i = 0; i < _monthly.size() ; i++)
		{
			if(_monthly.get(i).occursOn(year, month, day))
			{
				todaysTask.add(_monthly.get(i));
			}
		}
		for(int i = 0; i < _onetime.size(); i++)
		{
			if(_onetime.get(i).occursOn(year, month, day))
			{
				todaysTask.add(_onetime.get(i));
			}
		}
		return todaysTask;
	}
	
	/**
	 * Prints to the Screen all of the specified date's appointments
	 * @param year
	 * @param month
	 * @param day
	 */
	public void displayTodaysTasks(int year, int month, int day)
	{
		ArrayList<Appointment> today = this.getAppointments(year, month, day);
		System.out.println("Today's Appointments are as follows: ");
		if(today.isEmpty())
			System.out.println("\t There are not appointments today");
		else
		{
			for(int i = 0; i < today.size(); i++)
			{
			System.out.println("\t" + today.get(i).getDescription());
			}
		}
	}
	
	/**
	 * Prints to the screen all appointments within the book.
	 */
	public void displayBook()
	{
		System.out.println("Daily Appointments:");
		for(int i = 0; i < _daily.size(); i++)
		{
			System.out.println("\t" + _daily.get(i).getDescription());
		}
		System.out.println();
		
		System.out.println("Monthly Appointments:");
		for(int i = 0; i < _monthly.size(); i++)
		{
			System.out.println("\t Next Appointment for: " + _monthly.get(i).getDescription() + " Occurs every month starting on "
					+ _monthly.get(i).getDate().getDate());
		}
		System.out.println();
		
		System.out.println("One Time Appointments:");
		for(int i = 0; i < _onetime.size(); i++)
		{
			System.out.println("\t" + _onetime.get(i).getDescription() + " on " + day[_onetime.get(i).getDate().getDay()] + " "
			+ months[_onetime.get(i).getDate().getMonth()] + " " + _onetime.get(i).getDate().getDate() + " " 
			+ _onetime.get(i).getDate().getYear());
		}
		
	}
}
