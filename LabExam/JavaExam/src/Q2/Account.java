package Q2;

import java.util.Scanner;

public class Account {
	private Owner owner;
	private float balance;
	private String number;

	public Account() {

	}

	public Account(Owner owner, float balance, String number) {
		this.owner = owner;
		this.balance = balance;
		this.number = number;
	}

	public Account(Account account) {
      this(account.owner,account.balance,account.number);
	}

	public void input() {
       owner.input();
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter Balance: ");
       this.balance=sc.nextInt();
       System.out.println("Enter Number: ");
       this.number=sc.nextLine();
       sc.close();
	}

	public void print() {
		owner.print();
		System.out.println("Number: "+this.getNumber());
		System.out.println(" balance: "+this.getBalance());
	}

	@Override
	public String toString() {
		return "Owner: " + this.owner + " His Balance: " + this.balance + " Number: " + this.number;
	}

	public void deposit(int amount) {
		if (amount <= 0) {
			System.out.println("Invalid amount");
			return;
		}

		this.balance += amount;
	}

	public void withdraw(int amount) {
		if (amount <= 0) {
			System.out.println("Invalid amount");
			return;
		}
		this.balance -= amount;
	}

	public float getBalance() {
		return balance;
	}
	
	public Owner getOwner() {
		return owner;
	}
	
	public String getNumber() {
		return number;
	}

}
