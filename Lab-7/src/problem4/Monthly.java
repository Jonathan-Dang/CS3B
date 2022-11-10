package problem4;

import java.util.Date;

/**
 * A monthly appointment occurs on the same day of every month.
 */
public class Monthly extends Appointment{
	private static String type = "MONTHLY";
    /**
     * Constructor of a monthly appointment. Requires date and description.
     * @param year year of the appointment
     * @param month month of the appointment
     * @param day day of the appointment
     * @param description description of the appointment
     */
    public Monthly(int year, int month, int day, String description) {
        super(year, month, day, description);
    }

    /**
     * Check if the appointment occurs on a date.
     * @param year year of the date
     * @param month month of the date
     * @param day day of the date
     * @return true if monthly appointment occurs on the date
     */
    public boolean occursOn(int year, int month, int day) {
        Date appointment = super.getDate();
        Date checkDate = new Date(year, month - 1, day);
        return appointment.equals(checkDate) || (appointment.before(checkDate) && appointment.getDate() == day);
    }
    
    public String getType()
    {
    	return Monthly.type;
    }
}
