//Author: Jonathan Dang
//Project: PP9.2
package PP9_2;

public class ClockTester {
	public static void main(String[] args)
	{
		Clock c = new Clock();
		System.out.println(c.getTime());
		System.out.println(c.getTime12Hr());
		
		WorldClock wc = new WorldClock(3);
		System.out.println(wc.getTime());
		System.out.println(wc.getTime12Hr());
	}
}
