package q7_DivisionProgram;

import java.util.Scanner;

public class Division {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter numerator: ");
		int a = sc.nextInt();
		System.out.println("Enter Denomnator: ");
		int b = sc.nextInt();

		// closing the scanner
		sc.close();

		try {
			int answer = a / b;
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage() + " Denomnator Cant be zero");
		} finally {
			System.out.println("Inside finally block");
		}

	}
}
