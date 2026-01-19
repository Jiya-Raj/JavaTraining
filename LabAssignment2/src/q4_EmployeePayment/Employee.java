package q4_EmployeePayment;

import q5_PaymentSystem.Payable;

abstract public class Employee implements Payable {
	private String name;
	private String empID;

	public String getName() {
		return name;
	}

	public String getEmpID() {
		return empID;
	}

	public Employee(String name, String empID) {
		this.name = name;
		this.empID = empID;
	}

}
