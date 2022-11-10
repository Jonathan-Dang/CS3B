//Author: Jonathan Dang
//Project: Assignment 4: Chapters 4, 5, 6

/**
 * A Class in which will calculate Varience, Standard deviation, Mean|Average, and Margin of error
 * given a data set
 * @author Jonathan Dang
 *
 */
public class DataSet {
	//Member Variables
	private double sum;
	private double sumSquared;
	private int count;
	private double[] data;
	private final int DEFAULT_CAP = 500;
	
	//Constructor
	/**
	 * Constructs a DataSet with default parameters
	 */
	public DataSet()
	{
		sum = 0;
		sumSquared = 0;
		count = 0;
		data = new double[DEFAULT_CAP];
	}
	
	/**
	 * Constructs a DataSet with a pre-made set
	 * @param double[] set
	 */
	public DataSet(double[] set)
	{
		sum = 0;
		sumSquared = 0;
		count = 0;
		for(int i = 0; i < set.length; i++)
		{
			data[i] = set[i];
		}
		this.addSet(set);
	}
	
	//Class Methods
	/**
	 * Adds a single value to the recorded set
	 * @param double value
	 */
	public void add(double value)
	{
		count++;
		sum += value;
		sumSquared += Math.pow(value, 2);
		data[count - 1] = value;
	}
	
	/**
	 * Adds an entire set to the pre-existing recorded values
	 * @param set
	 */
	public void addSet(double[] set)
	{
		int setCount = set.length;
		
		for(int i = 0; i < setCount; i++)
		{
			this.add(set[i]);
		}
	}
	
	/**
	 * Returns an average from recorded data
	 * @return Average from recorded Data
	 */
	public double getAverage()
	{
		return sum/count;
	}
	
	/**
	 * Returns a double array in which contains the data set
	 * @return double[] set
	 */
	public double[] getSet()
	{
		return data;
	}
	
	/**
	 * Returns the amount of entries in this run
	 * @return Count
	 */
	public double getCount()
	{
		return count;
	}
	
	/**
	 * Returns the sum of the data set
	 * @return sum
	 */
	public double getSum()
	{
		return sum;
	}
	
	/**
	 * Uses an Unstable Numerical Based equation in order to calculate for Standard Deviation
	 * @return Standard Deviation | 97% accuracy
	 * WARNING: RELATIVELY INACCURATE FROM THE MORE STABLE FORMULA
	 */
	public double getUnstableStandardDeviation()
	{
		double SD = Math.pow(sum, 2);
		SD = (1/count) * SD;
		SD = sumSquared - SD;
		SD = SD / (sum - 1);
		return Math.sqrt(SD);
	}
	/**
	 * Uses an array to calculate Standard Deviation
	 * @return Standard Deviation
	 */
	public double getStandardDeviation()
	{
		double SOAN = 0;
		
		for(int i = 0; i < count; i++)
		{
			double temp = (data[i] - (sum/count));
			SOAN += Math.pow(temp, 2);
		}
		SOAN = SOAN/count;
		
		return Math.sqrt(SOAN);
	}
	
	/**
	 * Calculates the Margin of error with the recorded values
	 * @return Margin of Error
	 */
	public double getMarginOfError()
	{
		return getStandardDeviation()/Math.sqrt(count);
	}
	
	/**
	 * Calculates the Variance of the data set
	 * @return Variance
	 */
	public double getVariance()
	{
		return Math.pow(getStandardDeviation(),2);
	}
	
	/**
	 * Clears all data stored and sets all parameters to 0
	 */
	public void reset()
	{
		sum = 0;
		sumSquared = 0;
		for(int i = 0; i < count; i ++)
		{
			data[i] = 0;
		}
		count = 0;
	}
}
