package problem4;

import java.util.Date;

/**
 * A onetime appointment occurs only once.
 */
public class Onetime extends Appointment {
	private static String type = "ONETIME";
    /**
     * Constructor of a onetime appointment. Requires date and description.
     * @param year year of the appointment
     * @param month month of the appointment
     * @param day day of the appointment
     * @param description description of the appointment
     */
    public Onetime(int year, int month, int day, String description) {
        super(year, month, day, description);
    }

    /**
     * Check if the appointment occurs on a date.
     * @param year year of the date
     * @param month month of the date
     * @param day day of the date
     * @return true if appointment occurs on this date.
     */
    public boolean occursOn(int year, int month, int day) {
        return super.getDate().equals(new Date(year, month - 1, day));
    }
    
    public String getType()
    {
    	return Onetime.type;
    }
}