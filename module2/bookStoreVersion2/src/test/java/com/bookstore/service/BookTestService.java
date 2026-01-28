package com.bookstore.service;

import java.util.List;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookDaoJdbcImpl;
import com.bookstore.dto.Book;
import com.bookstore.exception.ServiceException;
import com.bookstore.service.BookService;
import com.bookstore.service.BookServiceImpl;

public class BookTestService {

	private BookService bookservice;
	BookDao bookdao = new BookDaoJdbcImpl();

	@BeforeEach
	void beforeTest() {
		bookservice = new BookServiceImpl(bookdao);
	}

	@Test
	@DisplayName("Test: adding Book increase count")
	void addBook_ShouldIncreaseCount() {
		List<Book> oldList = bookservice.getAllBooks();
		bookservice.addBook(new Book("abc123", "Programming with python", "XYZ", 200.0));
		List<Book> newList = bookservice.getAllBooks();
		assertEquals(oldList.size() + 1, newList.size());
	}

	@Test
	@DisplayName("Test: adding Book through Exception")
	void invalidBook_shouldThroughException() {
		Book bookWithInvalidPrice = new Book("439df", "pqr", "mno", 0);
		Book bookWithEmptyTitle = new Book("439df", "", "mno", 589.0);
		assertThrows(ServiceException.class, () -> bookservice.addBook(bookWithInvalidPrice));
		assertThrows(ServiceException.class, () -> bookservice.addBook(bookWithEmptyTitle));

	}

	@Test
	@DisplayName("Test: getting Book using valid Id")
	void validId_shouldReturnObject() {
		Book book = bookservice.addBook(new Book("ISBN-T1", "JUnit Book", "Tester", 300));

		assertNotNull(bookservice.getBookById(book.getId()));
	}

	@Test
	@DisplayName("Test: adding Book using invalid Id")
	void invalidId_shouldThrowException() {
		assertThrows(ServiceException.class, () -> bookservice.getBookById(-10));
	}

	@Test
	@DisplayName("Test: Deleting Book")
	void DeletingBook_shouldDecreaseCount() {
		Book book = bookservice.addBook(new Book("ISBN-T2", "Delete Me", "Tester", 250));
		int oldCount = bookservice.getAllBooks().size();
		bookservice.deleteBook(book.getId());
		int newCount = bookservice.getAllBooks().size();
		assertEquals(oldCount - 1, newCount);
	}

	@Test
	@DisplayName("Test: Deleting Book with Invalid Id")
	void DeletingBookWithInvalidId_shouldThrowException() {
		assertThrows(ServiceException.class, () -> bookservice.getBookById(-9));
	}

	@Test
	@DisplayName("Test: updateBook should update fields")
	void updateBook_shouldUpdateFields() {

		Book book = bookservice.addBook(new Book("ISBN-U1", "Old Title", "Old Author", 300));

		bookservice.updateBook(book.getId(), new Book("ISBN-U1", "New Title", "New Author", 450));

		Book updatedBook = bookservice.getBookById(book.getId());

		assertEquals("New Title", updatedBook.getTitle());
		assertEquals("New Author", updatedBook.getAuthor());
		assertEquals(450, updatedBook.getPrice());
		assertNotEquals("Old Title", updatedBook.getTitle());
	}

	@Test
	@DisplayName("Test: updateBook with invalid data should throw exception")
	void updateBook_withInvalidData_shouldThrowException() {

		Book book = bookservice.addBook(new Book("ISBN-U2", "Valid Title", "Valid Author", 400));

		// null title
		assertThrows(ServiceException.class,
				() -> bookservice.updateBook(book.getId(), new Book("ISBN-U2", null, "Author", 400)));

		// negative price
		assertThrows(ServiceException.class,
				() -> bookservice.updateBook(book.getId(), new Book("ISBN-U2", "Title", "Author", -100)));
	}

}