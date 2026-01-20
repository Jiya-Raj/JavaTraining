package q5_UserRegistration;

public class UserRegistration {

	public static void registerUser(String username, String userCountry) throws InvalidCountryException {

		if (!"India".equalsIgnoreCase(userCountry)) {
			throw new InvalidCountryException("User Outside India cannot be registered");
		}

		System.out.println("User registration done successfully");
	}
}
