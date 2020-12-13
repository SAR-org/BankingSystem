package banking;

/**
 *
 * Private Variables:<br>
 * {@link #accountNumber}: Long<br>
 * {@link #bank}: Bank<br>
 */
public class Transaction {
	private Long accountNumber;
	private Bank bank;
	private int attemptedPin;

	/**
	 *
	 * @param bank
	 *            The bank where the account is housed.
	 * @param accountNumber
	 *            The customer's account number.
	 * @param attemptedPin
	 *            The PIN entered by the customer.
	 * @throws Exception
	 *             Account validation failed.
	 */
	public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
		this.accountNumber = accountNumber;
		this.bank = bank;
		this.attemptedPin = attemptedPin;
		if(!bank.authenticateUser(accountNumber, attemptedPin)) {
			throw new Exception();
		}
	}

	public double getBalance() {
		// complete the function
        return bank.getBalance(accountNumber);
	}

	public void credit(double amount) {
		bank.credit(accountNumber, amount);
	}

	public boolean debit(double amount) {
		
		if(bank.authenticateUser(accountNumber, attemptedPin)) {
			boolean debitSuccess = bank.debit(accountNumber, amount);
			
			return debitSuccess;
		}else {
			return false;
		}
		
	}
}
