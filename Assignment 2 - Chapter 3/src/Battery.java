
public class Battery {
	//Member Variables
	private double _capacity;
	private double _charge;
	
	//Constructors
	/**
	 * Constructs a Battery with Default Parameters
	 */
	public Battery()
	{
		_capacity = 3000;
		_charge = 3000;
	}
	
	/**
	 * Constructs a Battery with @param capacity
	 */
	public Battery(double capacity)
	{
		_capacity = capacity;
		_charge = capacity;
	}
	
	//Methods
	/**
	 * Using @param capacity, removes that amount of charge
	 */
	public void drain(double capacity)
	{
		if(_charge < capacity)
			_charge = 0;
		else
			_charge -= capacity;
	}
	
	/**
	 * A parameter-less function that sets the charge back to the original setting
	 */
	public void charge()
	{
		_charge = _capacity;
	}
	
	/**
	 * A parameter-less function that returns the remaining charge in the battery
	 * @returns _charge
	 */
	public double getRemainingCapacity()
	{
		return _charge;
	}
}
