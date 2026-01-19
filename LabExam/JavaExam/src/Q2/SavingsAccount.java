package Q2;

import java.util.Scanner;

public class SavingsAccount extends Account {
	private float InterestRate;

	public SavingsAccount() {
		super();
		InterestRate = 5;
	}

	public SavingsAccount(SavingsAccount account) {
		super(account.getOwner(), account.getBalance(), account.getNumber());
		InterestRate = account.InterestRate;
	}

	public float getInterestRate() {
		return InterestRate;
	}

	public float getInterest() {
		return getBalance() * InterestRate / 100;
	}

	@Override
	public String toString() {
		return "Number: " + this.getNumber() + " balance: " + this.getBalance() + " InterestRate: "
				+ this.getInterestRate();
	}

	public void input() {
		super.input();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter interest rate : ");
		this.InterestRate = sc.nextInt();
		sc.close();
	}

	public void print() {
		super.print();
		System.out.println(" InterestRate: " + this.getInterestRate());
	}

}
