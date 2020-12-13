package banking;

import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
	
	public Bank() {
		accounts = new LinkedHashMap<Long, Account>();
	}
	
	public Long getLongAccountNumber() {
		if(accounts.size()==0) {
			//System.out.println("Account size========>>>"+accounts.size());
			return 1L;
		}else {
			//System.out.println("Account size========>>>"+accounts.size());
			return Long.parseLong(String.valueOf(accounts.size()+1));
		}
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		
		CommercialAccount commercialAccount 
		= new CommercialAccount(company, getLongAccountNumber(), pin, startingDeposit);
		accounts.put(commercialAccount.getAccountNumber(), commercialAccount);
		 return commercialAccount.getAccountNumber();
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		ConsumerAccount consumerAccount 
		= new ConsumerAccount(person, getLongAccountNumber(), pin, startingDeposit);
		accounts.put(consumerAccount.getAccountNumber(), consumerAccount);
		return consumerAccount.getAccountNumber();
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		Account account = accounts.get(accountNumber);
		return account.validatePin(pin);
		
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		
		if(accounts.get(accountNumber) !=null) {
			return accounts.get(accountNumber).getBalance();
		}else {
			return 0;
		}
        
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		if(accounts.get(accountNumber)!=null) {
			accounts.get(accountNumber).creditAccount(amount);
		}
		
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
        return accounts.get(accountNumber).debitAccount(amount);
	}
}
