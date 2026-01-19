package q2_BookCollection;

import java.util.*;

public class BookCollection {
	private String ownerName;
	private Book[] books;

	public BookCollection(String ownerName, Book[] books) {
		this.ownerName = ownerName;
		this.books = books;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public boolean hasBook(Book requiredBook) {
		for (Book book : books) {
			if (book.equals(requiredBook)) {
				return true;
			}
		}
		return false;
	}

	public void sort() {
       Arrays.sort(books,new Comparator<Book>() {
    	   
    	   @Override
    	   public int compare(Book b1,Book b2) {
    		   int titleCompare = b1.getTitle().compareTo(b2.getTitle());
               if (titleCompare != 0) {
                   return titleCompare;
               }
               return b1.getAuthor().compareTo(b2.getAuthor()); 
    	   }
       });
	}

@Override
   public String toString() {
	StringBuilder sb = new StringBuilder();
    sb.append("Owner: ").append(ownerName).append("\n");
    sb.append("Books:\n");
    for (Book book : books) {
        sb.append(book).append("\n");
    }
    return sb.toString();
   }
}
