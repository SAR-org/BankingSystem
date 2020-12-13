package banking;

/**
 * Abstract bank account class.<br>
 * <br>
 *
 * Private Variables:<br>
 * {@link #accountHolder}: AccountHolder<br>
 * {@link #accountNumber}: Long<br>
 * {@link #pin}: int<br>
 * {@link #balance}: double
 */
public abstract class Account extends AccountHolder{
	private Long accountNumber;
	private int pin;
	private double balance;

	protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
		super(accountHolder.getIdNumber());
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = startingDeposit;
				
	}
	public boolean validatePin(int attemptedPin) {
		
        return pin==attemptedPin;
	}

	public double getBalance() {
        return balance;
	}

	public Long getAccountNumber() {
		// complete the function
        return accountNumber;
	}

	public void creditAccount(double amount) {
		balance = balance+amount;
	}

	public boolean debitAccount(double amount) {
		//System.out.println("balance on account numner=====> "+accountNumber+"===> "+balance);
		if(balance>=amount) {
			balance = balance - amount;
			return true;
		}else {
			return false;
		}
	}
}
