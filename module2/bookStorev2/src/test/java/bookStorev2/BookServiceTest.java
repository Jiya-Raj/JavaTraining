package bookStorev2;

import java.util.List;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bookstore.dto.Book;
import com.bookstore.service.BookService;
import com.bookstore.service.BookServiceImpl;

public class BookServiceTest {

	private BookService bookservice;

	@BeforeEach
	void beforeTest() {
		bookservice = new BookServiceImpl();
	}

	@Test
	@DisplayName("Test: adding Book increase count")
	void addBook_ShouldIncreaseCount() {
		List<Book> oldList = bookservice.getAllBooks();
		bookservice.addBook(new Book("abc123", "Programming with python", "XYZ", 200.0));
		List<Book> newList = bookservice.getAllBooks();
		assertEquals(oldList.size(), newList.size());
	}

	@Test
	@DisplayName("Test: adding Book through Exception")
	void invalidBook_shouldThroughException() {
		Book bookWithInvalidPrice = new Book("439df", "pqr", "mno", 0);
		Book bookWithEmptyTitle = new Book("439df", "", "mno", 589.0);
	}

//	@Test
//	void deleteBook_ShouldDecreaseCount() {
//		List<Book> oldList = bookservice.getAllBooks();
//		bookservice.addBook(new Book("abc123", "Programming with python", "XYZ", 200.0));
//		List<Book> newList = bookservice.getAllBooks();
//		assertEquals(oldList.size(), newList.size());
//	}

}
