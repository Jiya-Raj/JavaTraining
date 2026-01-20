package q6_CommandLineValidation;

public class AgeValidator {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Usage: java AgeValidator <Name> <Age>");
			return;
		}

		String name = args[0];
		int age;

		try {
			age = Integer.parseInt(args[1]);

			validateAge(age);

			System.out.println("Name: " + name + ", Age: " + age);

		} catch (NumberFormatException e) {
			System.out.println("Age must be a valid number");
		} catch (InvalidAgeException e) {
			System.out.println("InvalidAgeException: " + e.getMessage());
		}
	}

	public static void validateAge(int age) throws InvalidAgeException {
		if (age < 18 || age >= 60) {
			throw new InvalidAgeException("Age must be between 18 and 59");
		}
	}
}
