package PP10_4;

/**
 * Bank Account Measurer
 * @author Jonathan Dang
 *
 */
public class BankAccountMeasurer implements Measurer
{
	/**
	 * @returns the balance of a bank account
	 */
	@Override
	public double measure(Object anObject) {
		BankAccount b = (BankAccount) anObject;
		return b.getBalance();
	}
}
