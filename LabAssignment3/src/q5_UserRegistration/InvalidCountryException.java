package q5_UserRegistration;

public class InvalidCountryException extends Exception {

	public InvalidCountryException() {
		super("Invalid country. User registration failed.");
	}

	public InvalidCountryException(String message) {
		super(message);
	}
}
