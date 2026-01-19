package q2_BookStore;

import java.util.*;

public class BookStore {
	private Book[] books;
	private int bookCount;

	public BookStore() {
		this.books = new Book[10];
		bookCount = 0;
	}

	public void sell(String title, int count) {
		if (count <= 0) {
			System.out.println("Invalid sale quantity.");
			return;
		}

		for (int i = 0; i < bookCount; i++) {
			Book book = books[i];

			if (book.getBookTitle().equalsIgnoreCase(title)) {
				if (book.getNumOfCopies() < count) {
					System.out.println("Not enough stock.");
				} else {
					book.setNumOfCopies(book.getNumOfCopies() - count);
				}
				return;
			}
		}
		System.out.println("Book not found.");
	}

	public void order(String isbn, int count) {
		if (count <= 0) {
			System.out.println("Invlaid Quantity");
			return;
		}

		for (int i = 0; i < bookCount; i++) {
			Book book = books[i];
			if (book.getISBN().equals(isbn)) {
				book.setNumOfCopies(book.getNumOfCopies() + count);
				return;
			}
		}

		if (bookCount == books.length) {
			System.out.println("Bookstore is full.");
			return;
		}

		// if Book is not there
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter title: ");
		String Title = sc.nextLine();
		System.out.print("Enter author: ");
		String Author = sc.nextLine();
		Book newBook = new Book(Title, Author, isbn, count);
		books[bookCount++] = newBook;

	}

	public void display() {
		if (bookCount == 0) {
			System.out.println("No Books in inventory");
			return;
		}

		for (int i = 0; i < bookCount; i++) {
			books[i].display();
		}
	}

}
