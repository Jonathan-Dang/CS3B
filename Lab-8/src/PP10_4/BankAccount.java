package PP10_4;
/**
 * Bank Account Object
 * @author Jonathan Dang
 *
 */
public class BankAccount
{	
	private double _balance = 0;
	
	/**
	 * Constructs a Bank Account with a preset Balance
	 * @param bal
	 */
	public BankAccount(double bal)
	{
		_balance = bal;
	}
	
	/**
	 * Deposits a select amount > 0 into the bank account
	 * @param amount
	 */
	public void deposit(double amount)
	{
		if(amount >= 0)
			_balance += amount;
		else
			throw new IllegalArgumentException("Invalid Deposit Amount");
	}
	
	/**
	 * Removes a select amount from the bank account
	 * @param amount
	 */
	public void withdraw(double amount)
	{
		if(amount > _balance)
			throw new IllegalArgumentException("Amount specified goes over Balance");
		else if(amount < 0)
			throw new IllegalArgumentException("Invalid Withdrawl Amount.");
		else
			_balance -= amount;
	}
	
	/**
	 * Obtains the balance within the bank account
	 * @returns the balance
	 */
	public double getBalance()
	{
		return _balance;
	}
}
