package q4_EmployeePayment;

import java.util.ArrayList;

public class EmployeePayment {
		public static void main(String[] args) {
			ArrayList<Employee> employees = new ArrayList<>();

			// Add one of each type
			employees.add(new SalariedEmployee("Alice", "E001", 1500));
			employees.add(new HourlyEmployee("Bob", "E002", 40, 20));
			employees.add(new CommissionEmployee("Charlie", "E003", 5000, 10));

			// Loop through employees and print weekly salary
			for (Employee emp : employees) {
				System.out.println(emp.getName() + " (ID: " + emp.getEmpID() + ") earns: $" + emp.getPayment());
			}
		}
	}
