package q3_Bank;

public class CurrentAccount extends Account {
	private int tradeLicenseNumber;
	private double overdraft = 1000;

	public CurrentAccount(String name, String accountNumber, double initialBalance, double overdraft) {
		super(name, accountNumber, initialBalance);
		this.overdraft = overdraft;
	}

	public double getBalance() {
		return balance;
	}

	public void setTradeLicenseNumber(int licenseNumber) {
		this.tradeLicenseNumber = licenseNumber;
	}

	public int getTradeLicenseNumber() {
		return tradeLicenseNumber;
	}

	@Override
	public void withdraw(double amount) {
		if (amount <= 0) {
			System.out.print("Invalid amount");
			return;
		}

		if (amount <= balance + overdraft) {
			balance -= amount;
		} else {
			System.out.println("Withdrawal exceeds overdraft limit.");
		}
	}
}
