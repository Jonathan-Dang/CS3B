package assignment8;

/**
 * Interface Sequence is a string of numbers
 * @author Jonathan Dang
 *
 */
public interface Sequence {
	default int next()
	{
		return 0;
	}
	
	default boolean hasNext()
	{
		return false;
	}
}
