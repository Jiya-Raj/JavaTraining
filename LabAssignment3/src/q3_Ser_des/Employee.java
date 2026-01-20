package q3_Ser_des;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	int id;
	String name;
	Address address;
	transient double salary; // non-serializable

	public Employee(int id, String name, Address address, double salary) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	public void display() {
		System.out.println("Employee ID   : " + id);
		System.out.println("Employee Name : " + name);
		address.display();
		System.out.println("Salary        : " + salary);
	}
}
