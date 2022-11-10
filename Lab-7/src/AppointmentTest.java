/*
    Author: Zaojia Zhao
    Course: CS 3B Spring 2021
    Project: Lab 7 P 9.4
    Input: a date separated by slash
    Output: Appointments on that date
    Processing: Program will check the existing appointments with the date to determine if any appointment occurs on that date.
 */

import problem4.Appointment;
import problem4.Onetime;
import problem4.Daily;
import problem4.Monthly;
import PP9_5.AppointmentBook;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class AppointmentTest {
    @SuppressWarnings("unused")
	public static void main(String[] args) {
    	//PP9.4 Assignment Testing
        /*Appointment[] app = new Appointment[5];

        app[0] = new Onetime(2021, 3, 13, "See the cardiologist.");
        app[1] = new Onetime(2021, 3, 14, "See the dentist.");
        app[2] = new   Daily(2021, 2, 13, "See the school doctor.");
        app[3] = new Monthly(2021, 1, 13, "See the family doctor.");
        app[4] = new Monthly(2021, 4, 14, "See the vet.");

        Scanner in = new Scanner(System.in);
        String input;
        int month, day, year;

        while (true) {
            System.out.print("Please enter the date (Ex: 1/10/2021): ");
            input = in.next();
            Scanner delimited = new Scanner(input).useDelimiter("/");
            try {
                month = delimited.nextInt();
                day = delimited.nextInt();
                year = delimited.nextInt();
                if (delimited.hasNext())
                    System.out.println("Redundant values are entered after the date.\n");
                else {
                    Appointment temp = new Appointment(year, month, day, "");       //use Appointment constructor to check if input is valid
                    delimited.close();
                    break;
                }
            } catch (IllegalArgumentException | NoSuchElementException e) {
                if (e instanceof NoSuchElementException)
                    System.out.println("Date entered is invalid.\n");
                else
                    System.out.println(e.getMessage() + "\n");
            }
        }

        System.out.printf("Appointments on %d/%d/%d:\n", month, day, year);
        for (int i = 0; i < 5; i++) {
            if (app[i].occursOn(year, month, day))
                System.out.println("    " + app[i].getDescription());
        }
        in.close();*/
    	AppointmentBook AB = new AppointmentBook();
    	Scanner in = new Scanner(System.in);
        String input;
        int month, day, year;
        
        System.out.println("In this simulation, we have an appointment book."
        		+ " You will enter the date, type, and description of each inputted appointment");
        while (true) {
            System.out.print("Please enter the date (Ex: 1/10/2021): ");
            input = in.next();
            Scanner delimited = new Scanner(input).useDelimiter("/");
            month = delimited.nextInt();
            day = delimited.nextInt();
            year = delimited.nextInt();
            if (delimited.hasNext())
                System.out.println("Redundant values are entered after the date.\n");
            else 
            {
            	Scanner ins = new Scanner(System.in);
                Appointment temp = new Appointment(year, month, day, "");
                System.out.print("Please enter the description (Ex: See Eye Doctor): ");
                String desc = ins.nextLine();
                System.out.print("Please enter the Appointment type (Daily, Monthly, OneTime):");
                String type = ins.next();
                
                AB.addAppointment(type, desc, day, month, year);
                
                System.out.print("If you wish to continue to add appointments enter Y or enter anything else to stop: ");
                String choice = ins.next();
                if(!choice.equals("Y"))
                {
                	break;
                }
            }
            delimited.close();
        }
        System.out.println();
        AB.displayBook();
    	
    	
        System.out.print("\n\n========================================== MAIN EXIT ======================================\n\n");
    }
}


/* --------------------------- Sample Run -------------------------------------
In this simulation, we have an appointment book. You will enter the date, type, and description of each inputted appointment
Please enter the date (Ex: 1/10/2021): 4/24/2021
Please enter the description (Ex: See Eye Doctor): Go to the Dentist
Please enter the Appointment type (Daily, Monthly, OneTime):OneTime
If you wish to continue to add appointments enter Y or enter anything else to stop: Y
Please enter the date (Ex: 1/10/2021): 4/3/2021
Please enter the description (Ex: See Eye Doctor): Read That Book
Please enter the Appointment type (Daily, Monthly, OneTime):Daily
If you wish to continue to add appointments enter Y or enter anything else to stop: Y
Please enter the date (Ex: 1/10/2021): 4/30/2021
Please enter the description (Ex: See Eye Doctor): Pay the Bills
Please enter the Appointment type (Daily, Monthly, OneTime):Monthly
If you wish to continue to add appointments enter Y or enter anything else to stop: N

Daily Appointments:
	Read That Book

Monthly Appointments:
	 Next Appointment for: Pay the Bills Occurs every month starting on 30

One Time Appointments:
	Go to the Dentist on Mon Apr 24 2021


========================================== MAIN EXIT ======================================

 */