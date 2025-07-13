package synchronization;

public class DepositLimitException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DepositLimitException()
	{
		super("Daily Limit of deposit is exceed.....");
	}
	public DepositLimitException(String message )
	{
		super (message);
	}
}