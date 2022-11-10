package PP10_4;

/**
 * Data object provided by Example 10.4
 * @author Jonathan Dang | The Book
 *
 */
public class Data
{
	public static double average(Object[] objects, Measurer mess, Filter fil)
	{
		if(objects.length < 0)
			return 0;
		
		double sum = 0;
		for(Object obj : objects)
		{
			if(fil.accept(obj))
				sum += mess.measure(obj);
		}
		return sum/objects.length;
	}
}
