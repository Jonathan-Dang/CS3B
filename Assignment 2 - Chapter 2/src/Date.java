//Author: Dang, Jonathan
//Project: Local Date | Project 2.10
import java.time.LocalDate;

public class Date {
	public static void main(String[] arg)
	{
		System.out.println("===============Program Start===============");
		//Variable Initialization
		LocalDate piDay = LocalDate.of(2021, 3, 14);
		LocalDate programDay = LocalDate.of(2020,12,31).plusDays(256);
		LocalDate todayButBefore = LocalDate.now().minusDays(10000);
		//Display
		System.out.println("Pi Day is on 2021-3-14 which is on " + piDay.getDayOfWeek().toString());
		System.out.println("Programmer's day is on " + programDay + " which is on " + programDay.getDayOfWeek().toString());
		System.out.println("10,000 days ago from today is " + todayButBefore + " which is on " + todayButBefore.getDayOfWeek().toString());
		
		System.out.println("===============Program END===============");
		return;
	}
}

//Sample Run
/*
===============Program Start===============
Pi Day is on 2021-3-14 which is on SUNDAY
Programmer's day is on 2021-09-13 which is on MONDAY
10,000 days ago from today is 1993-10-09 which is on SATURDAY
===============Program END===============
*/