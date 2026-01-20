package q4_BookFileParsing;

public class Book {

    int id;
    String isbn;
    String title;
    String author;
    double price;
    int quantity;

    public Book(int id, String isbn, String title, String author, double price, int quantity) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public void display() {
        System.out.println(id + " | " + isbn + " | " + title + " | " +
                author + " | Price: " + price + " | Qty: " + quantity);
    }
}
