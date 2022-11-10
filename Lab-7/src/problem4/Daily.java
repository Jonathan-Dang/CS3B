package problem4;

import java.util.Date;

/**
 * A daily appointment occurs on every day.
 */
public class Daily extends Appointment {
	private static String type = "DAILY";
    /**
     * Constructor of a daily appointment. Requires date and description.
     * @param year year of the appointment
     * @param month month of the appointment
     * @param day day of the appointment
     * @param description description of the appointment
     */
    public Daily(int year, int month, int day, String description) {
        super(year, month, day, description);
    }

    /**
     * Check if the appointment occurs on a date.
     * @param year year of the date
     * @param month month of the date
     * @param day day of the date
     * @return true if the date is after the first appointment
     */
    public boolean occursOn(int year, int month, int day) {
        Date appointment = super.getDate();
        Date checkDate = new Date(year, month - 1, day);
        return appointment.equals(checkDate) || appointment.before(checkDate);
    }
    
    public String getType()
    {
    	return Daily.type;
    }
}
