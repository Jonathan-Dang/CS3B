package problem4;

import java.util.Date;

/**
 * An appointment classes records the date and description of the appointment.
 */
public class Appointment {
    private Date date;              //date of the appointment
    private String description;     //description of the appointment

    /**
     * Constructor of an appointment. Requires date and description.
     * @param year year of the appointment
     * @param month month of the appointment
     * @param day day of the appointment
     * @param description description of the appointment
     */
    public Appointment(int year, int month, int day, String description) {
        date = new Date(year, month - 1, day);
        if (month - 1 != date.getMonth() || year != date.getYear())
            throw new IllegalArgumentException("Invalid date.");            //throw error if date is invalid
        this.description = description;
    }

    /**
     * Gets the description of the appointment.
     * @return description of the appointment.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the date of the appointment.
     * @return date of the appointment
     */
    public Date getDate() {
        return date;
    }

    /**
     * Check if the appointment occurs on a date.
     * @param year year of the date
     * @param month month of the date
     * @param day day of the date
     * @return true if appointment occurs on this date.
     */
    public boolean occursOn(int year, int month, int day) {
        return date.equals(new Date(year, month - 1, day));
    }
    
    @Override
    public String toString()
    {
    	return this.date.toString() + " | " + this.description;
    }

}
