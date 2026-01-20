package q3_Ser_des;

import java.io.*;

public class Main {

	public static void main(String[] args) {

		String filePath = "src\\q3_Ser_des\\employee.ser";

		Address address = new Address("Mumbai", "Maharashtra");
		Employee emp = new Employee(101, "Rahul", address, 75000.50);

		// -------- Serialization --------
		serializeEmployee(emp, filePath);

		// -------- Deserialization --------
		Employee deserializedEmp = deserializeEmployee(filePath);

		if (deserializedEmp != null) {
			System.out.println("\n--- Deserialized Employee Details ---");
			deserializedEmp.display();
		}
	}

	public static void serializeEmployee(Employee emp, String filePath) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {

			oos.writeObject(emp);
			System.out.println("Employee object serialized successfully.");

		} catch (IOException e) {
			System.out.println("Serialization Error: " + e.getMessage());
		}
	}

	public static Employee deserializeEmployee(String filePath) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {

			return (Employee) ois.readObject();

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Deserialization Error: " + e.getMessage());
		}
		return null;
	}
}
