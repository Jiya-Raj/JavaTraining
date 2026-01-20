package q4_BookFileParsing;

import java.io.*;
import java.util.LinkedList;

public class BookApp {
	static LinkedList<Book> books = new LinkedList<>();;

	public static void main(String[] args) {

		String filePath = "src\\q4_BookFileParsing\\books";
		readFile(filePath);

		// Search books
		Book reqBook = searchBook(102);
		if (reqBook != null) {
			reqBook.display();
		} else {
			System.out.println("Book not found");
		}

		// selling book
		try {
			sellBook("A234", 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// purchase book
		purchaseBook("A234", 1);
	}

	public static void readFile(String filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(":");

				Book book = new Book(Integer.parseInt(data[0]), data[1], data[2], data[3], Double.parseDouble(data[4]),
						Integer.parseInt(data[5]));
				books.add(book);
			}

			System.out.println("Books loaded from file successfully.");

		} catch (IOException e) {
			System.out.println("File Error: " + e.getMessage());
		}
	}

	public static Book searchBook(int id) {
		for (Book book : books) {
			if (book.id == id) {
				return book;
			}
		}
		return null;
	}

	public static void sellBook(String isbn, int noOfCopies) throws Exception {

		for (Book book : books) {
			if (book.isbn.equals(isbn)) {
				if (book.quantity < noOfCopies) {
					throw new Exception("Not enough copies available");
				}
				book.quantity -= noOfCopies;
				System.out.println("Book sold successfully.");
				return;
			}
		}
		System.out.println("Book with ISBN not found.");
	}

	public static void purchaseBook(String isbn, int noOfCopies) {

		for (Book book : books) {
			if (book.isbn.equals(isbn)) {
				book.quantity += noOfCopies;
				System.out.println("Book purchased successfully.");
				return;
			}
		}
		System.out.println("Book with ISBN not found.");
	}

	public static void displayAllBooks() {
		for (Book book : books) {
			book.display();
		}
	}
}
