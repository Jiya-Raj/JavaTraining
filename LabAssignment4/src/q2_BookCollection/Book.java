package q2_BookCollection;

import java.util.Objects;

public class Book {
	private String title;
	private String author;
	private double price;

	public Book(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Title: " + this.title + " author: " + this.author + " Price: " + this.price;
	}

	@Override
	public boolean equals(Object book) {
		if (this == book) {
			return true;
		} else if (book == null) {
			return false;
		} else if (this.getClass() != book.getClass()) {
			return false;
		}
		Book cBook = (Book) book;
		if ((this.title.equals(cBook.title)) && (this.author.equals(cBook.author))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, author);
	}
}
