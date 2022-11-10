package PP10_4;

/**
 * Bank Account Filter
 * @author Jonathan Dang
 *
 */
public class BankAccountFilter implements Filter
{
	private double _balanceFilter;
	
	/**
	 * Constructs a Bank Account Filter given a number to filter all accounts below given balance
	 * @param filt
	 */
	public BankAccountFilter(double filt)
	{
		_balanceFilter = filt;
	}
	
	/**
	 * Override that @returns true if it fulfills the filter
	 */
	@Override
	public boolean accept(Object x) {
		BankAccount b = (BankAccount) x;
		return b.getBalance() > _balanceFilter;
	}
	
	/**
	 * Sets the filter to a given amount > 0
	 * @param filt
	 */
	public void setFilterAmount(double filt)
	{
		if(filt < 0)
			throw new IllegalArgumentException("Invalid Filter.");
		
		_balanceFilter = filt;
	}
	
}
