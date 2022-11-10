package assignment8;

/**
 * An object that returns a random sequence
 * @author Jonathan Dang
 *
 */
public class RandomSequence implements Sequence 
{
	@Override
	public int next()
	{
		return (int) (Integer.MAX_VALUE * Math.random());
	}
}
