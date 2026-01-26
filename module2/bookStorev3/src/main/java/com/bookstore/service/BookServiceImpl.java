package com.bookstore.service;

import java.util.*;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookDaoJpaImpl;
import com.bookstore.dto.Book;
import com.bookstore.exception.DaoException;
import com.bookstore.exception.ServiceException;

public class BookServiceImpl implements BookService {
	private BookDao bookdao = new BookDaoJpaImpl();

	public BookServiceImpl(BookDao bookdao) {
		this.bookdao = bookdao;
	}

	@Override
	public List<Book> getAllBooks() throws ServiceException {
		List<Book> books = new ArrayList<>();
		try {
			books = bookdao.getAllBooks();
		} catch (DaoException e) {
			throw new ServiceException("Facing problems fetching Books", e);
		}

		return books;

	}

	@Override
	public Book addBook(Book book) throws ServiceException {
		if (book == null)
			throw new ServiceException("Book is invalid");

		if (book.getIsbn() == null || book.getIsbn().isEmpty()) {
			throw new ServiceException("ISBN can not be empty");
		}

		if (book.getTitle() == null || book.getTitle().isEmpty()) {
			throw new ServiceException("Title can not be empty");
		}

		if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
			throw new ServiceException("Author can not be empty");
		}

		if (book.getPrice() <= 0) {
			throw new ServiceException("Price Invalid");
		}

		try {
			return bookdao.addBook(book);
		} catch (DaoException e) {
			throw new ServiceException("Facing problems adding Book", e);
		}

	}

	@Override
	public void deleteBook(int id) throws ServiceException {
		if (id <= 0) {
			throw new ServiceException("Id is invalid");
		}

		try {
			bookdao.deleteBook(id);
		} catch (DaoException e) {
			throw new ServiceException("Facing problems Deleting Book", e);
		}

	}

	@Override
	public void updateBook(int id, Book book) throws ServiceException {
		if (id <= 0) {
			throw new ServiceException("Id is invalid");
		}

		try {
			bookdao.updateBook(id, book);
		} catch (DaoException e) {
			throw new ServiceException("Facing problems Updating Book", e);
		}

	}

	@Override
	public Book getBookById(int id) throws ServiceException {
		Book book = null;
		if (id <= 0) {
			throw new ServiceException("ID is invalid");
		}

		try {
			book = bookdao.getBookById(id);
		} catch (DaoException e) {
			throw new ServiceException("Facing problems Fetching  Book, Try again later.", e);
		}

		return book;
	}

}
