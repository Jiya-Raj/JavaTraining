package Q2;

import java.util.Scanner;

public class Owner {
	private String name;
	private Date dob;
	private String nic;

	public Owner() {
         dob=new Date();
	}

	public Owner(String name, String nic, Date date) {
		this.name = name;
		this.nic = nic;
		this.dob = date;
	}

	public Owner(Owner owner) {
		this(owner.name, owner.nic, owner.dob);
	}

	public void input() {
		dob.input();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name: ");
		this.name = sc.nextLine();
		System.out.println("Enter nic: ");
		this.nic = sc.nextLine();
		sc.close();
	}

	public void print() {
		dob.print();
		System.out.println("name: " + this.name);
		System.out.println("NIC: " + this.nic);
	}

	@Override
	public String toString() {
		return "Name: " + this.name + " NIC: " + this.nic + " Date of Birth: " + dob;
	}
}
