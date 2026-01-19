package q3_Bank;

public class Account {
	private String name;
	private String accountNumber;
	protected double balance;

	public String getName() {
		return name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getbalance() {
		return balance;
	}

	public Account(String name, String accountNumber, double initialBalance) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = initialBalance;
	}

	public void deposit(double amount) {
		if (amount <= 0) {
			System.out.println("Invalid amount");
			return;
		}
		balance += amount;
	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			System.out.println("Invalid amount");
			return;
		}

		if (balance < amount) {
			System.out.println("Not enough Balance available");
			return;
		}

		balance -= amount;
	}

}
