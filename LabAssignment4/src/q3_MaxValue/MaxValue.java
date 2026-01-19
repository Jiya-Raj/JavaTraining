package q3_MaxValue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MaxValue {

	public static void main(String[] args) {
		String filePath = "src\\q3_MaxValue\\data";

		List<Double> numbers = readDouble(filePath);
		printDoubles(numbers);
	}

	public static List<Double> readDouble(String filePath) {
		List<Double> numbers = new ArrayList<>();
		int lineNumber = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = br.readLine()) != null) {
				lineNumber++;
				line = line.trim();
				if (line.isEmpty())
					continue;

				double value = Double.parseDouble(line);
				numbers.add(value);
			}
			br.close();
		} catch (NumberFormatException e) {
			System.out.println("Invalid number at line: " + lineNumber);
		} catch (IOException e) {
			System.out.println("Error reading file : " + e.getMessage());
		}

		return numbers;
	}

	public static void printDoubles(List<Double> numbers) {
		if (numbers.isEmpty()) {
			System.out.println("No valid numbers in the File");
			return;
		}

		double max = Integer.MIN_VALUE;
		for (double num : numbers) {
			max = Math.max(max, num);
		}

		System.out.println("Largest value: " + max);
	}
}
