package q2_AccountSynchronization;

public class Account {

	private double balance;

	public Account(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public synchronized void addAmount(double amount) {
		balance += amount;
	}

	public synchronized void subtractAmount(double amount) {
		balance -= amount;
	}
}
