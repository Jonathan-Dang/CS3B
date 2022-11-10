package assignment8;

/**
 * Square Sequence
 * @author Jonathan Dang
 *
 */
public class SquareSequence implements Sequence 
{
	private int n;
	public SquareSequence()
	{
		n = 0;
	}
	
	/**
	 * Using n, will generate a sequence that constantly returns n^2 where
	 * n is the amount of times next() has been called.
	 */
	@Override
	public int next()
	{
		n++;
		return n*n;
	}
}
