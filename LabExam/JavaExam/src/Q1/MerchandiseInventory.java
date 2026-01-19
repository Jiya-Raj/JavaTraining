package Q1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class MerchandiseInventory {

	public static void main(String[] args) {
		ArrayList<Merchandise> merchandise = new ArrayList<>();
		try {
			BufferedReader bfr = new BufferedReader(new FileReader("src/Q1/input"));
			String line;
			while ((line = bfr.readLine()) != null) {
				line=line.trim();
				String[] li = line.split(" ");

				String itemId = li[0];
				int quantity = Integer.parseInt(li[1]);
				double price = Double.parseDouble(li[2]);

				Merchandise item = new Merchandise(itemId, quantity, price);
				merchandise.add(item);
			}
			bfr.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		// sort by name
		Collections.sort(merchandise, new ItemIdComparator());
		System.out.println("List sorted by itemId");
		for (Merchandise item : merchandise) {
			System.out.println(item);
		}

		// sort by price
		Collections.sort(merchandise, new PriceComparator());
		System.out.println("List sorted by Price (descending)");
		for (Merchandise item : merchandise) {
			System.out.println(item);
		}
	}

}
