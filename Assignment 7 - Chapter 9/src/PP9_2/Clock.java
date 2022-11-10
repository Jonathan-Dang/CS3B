//Author: Jonathan Dang
//Project: PP9.2
package PP9_2;
import java.time.LocalTime;
/**
 * Simple Clock Super Class
 * @author Jonathan Dang
 *
 */
public class Clock {
	/**
	 * Constructs a simple clock object
	 */
	public Clock()
	{
		//
	}
	
	/**
	 * Obtains the 24 hour clock's hours
	 * @returns hours from 24 hour clock
	 */
	public String getHours()
	{
		return LocalTime.now().toString().substring(0,2);
	}
	
	/**
	 * Obtains the clock's minutes
	 * @returns minutes from the clock
	 */
	public String getMinutes()
	{
		return LocalTime.now().toString().substring(3,5);
	}
	
	/**
	 * Obtains the Full Time in 24 hour clock
	 * @return The Time in 24 hours
	 */
	public String getTime()
	{
		return getHours() + ":" + getMinutes();
	}
	
	/**
	 * Obtains the Full time in 12 hour clock
	 * @returns the Time in 12 hours
	 */
	public String getTime12Hr()
	{
		String amPm = "";
		int time = Integer.parseInt(getHours());
		if(time > 12)
		{
			time -= 12;
			amPm = "PM";
		}
		else
			amPm = "AM";
		return time + ":" + getMinutes() + amPm;
	}
}
