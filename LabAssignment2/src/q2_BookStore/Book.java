package q2_BookStore;

public class Book {
	private String bookTitle;
	private String author;
	private String ISBN;
	private int numOfCopies;

	public Book(String bookTitle, String author, String ISBN, int copies) {
		if (bookTitle == null || bookTitle.length() == 0)
			throw new IllegalArgumentException("Book title cannot be empty.");
		if (author == null || author.length() == 0)
			throw new IllegalArgumentException("Author cannot be empty.");
		if (ISBN == null || ISBN.length() == 0)
			throw new IllegalArgumentException("ISBN cannot be empty.");

		this.bookTitle = bookTitle;
		this.author = author;
		this.ISBN = ISBN;
		setNumOfCopies(copies);
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public String getISBN() {
		return ISBN;
	}

	public int getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(int copies) {
		if (copies <= 0) {
			throw new IllegalArgumentException("Number of Books cant be zero");
		}
		this.numOfCopies = copies;
	}

	public void display() {
		System.out.println(bookTitle + "-" + author + "-" + ISBN + "-" + numOfCopies);
	}

}
