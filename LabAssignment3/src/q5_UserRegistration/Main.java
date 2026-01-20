package q5_UserRegistration;

public class Main {

	public static void main(String[] args) {

		try {
			UserRegistration.registerUser("Rahul", "India");
		} catch (InvalidCountryException e) {
			System.out.println(e.getMessage());
		}

		try {
			UserRegistration.registerUser("John", "USA");
		} catch (InvalidCountryException e) {
			System.out.println(e.getMessage());
		}
	}
}
