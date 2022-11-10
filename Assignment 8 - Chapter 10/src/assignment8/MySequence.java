package assignment8;
import java.util.ArrayList;

/**
 * A User Based Sequence
 * @author Jonathan Dang
 *
 */
public class MySequence implements Sequence 
{
	private ArrayList<Integer> _seq = new ArrayList<Integer>();
	private int pos;
	
	/**
	 * Constructs a MySequence Object
	 */
	public MySequence()
	{
		pos = 0;
	}
	
	/**
	 * Constructs a MySequence given an arrayList
	 * @param sequence
	 */
	public MySequence(ArrayList<Integer> sequence)
	{
		for(int i = 0; i < sequence.size();i++)
		{
			_seq.add(sequence.get(i));
		}
		pos = 0;
	}
	
	/**
	 * Adds the addMe Parameter to the sequence
	 * @param addMe
	 */
	public void addToSequence(int addMe)
	{
		_seq.add(addMe);
	}
	
	/**
	 * Checks if the sequence has a next number
	 */
	@Override
	public boolean hasNext()
	{
		return !(pos <= _seq.size() - 1);
	}
	
	/**
	 * Provides the next number in the sequence
	 */
	@Override
	public int next()
	{
		return _seq.get(pos++);
	}
	
	/**
	 * resets the position to 0
	 */
	public void reset()
	{
		pos = 0;
	}
}
