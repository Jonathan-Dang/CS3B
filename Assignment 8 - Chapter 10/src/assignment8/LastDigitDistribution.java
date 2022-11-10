package assignment8;

/**
 * Processor object to PP10.2 and PP10.4
 * @author Jonathan Dang
 *
 */
public class LastDigitDistribution implements Sequence
{
	private int counters[] = new int[10];
	
	public LastDigitDistribution()
	{
		//
	}
	
	/**
	 * Processes the amount of times a single digit appears in the last place of a number
	 * within a sequence section marked by valuesToProcess from seq
	 * @param seq
	 * @param valuesToProcess
	 */
	public void process(Sequence seq, int valuesToProcess)
	{
		for (int i = 1; i <= valuesToProcess; i++)
		{
			int value = seq.next();
			int lastDigit = value % 10;
			counters[lastDigit]++;
		}
	}
	
	/**
	 * Displays the statistics given from the counters[] array processed from the process() method
	 */
	public void display()
	{
		System.out.println("* -> 5 Entries");
		for(int i = 0; i < 10; i++)
		{
			System.out.print(i + ": ");
			for(int j = 0; j < counters[i] / 5; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
