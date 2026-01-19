package q2_BookCollection;

public class Test {

	public static void main(String[] args){
		Book[] books = {
	            new Book("Java Basics", "Raj", 350),
	            new Book("Spring Boot", "Sharma", 550),
	            new Book("Java in Depth", "Mehta", 450)
	        };

	        BookCollection collection = new BookCollection("Jiya Raj", books);

	        Book searchBook = new Book("Java in Depth", "Mehta", 0);

	        System.out.println("Book exists: " + collection.hasBook(searchBook));

	        collection.sort();

	        System.out.println(collection);
	}
}
