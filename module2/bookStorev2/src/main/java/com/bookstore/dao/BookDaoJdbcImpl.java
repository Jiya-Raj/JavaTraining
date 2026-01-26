package com.bookstore.dao;

import com.bookstore.exception.*;
import java.util.*;
import com.bookstore.dto.Book;
import com.bookstore.util.ConnectionFactory;
import java.sql.*;

public class BookDaoJdbcImpl implements BookDao {

	private Connection connection;

	public BookDaoJdbcImpl() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from books");
			while (rs.next()) {
				books.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
			}

		} catch (SQLException e) {
			throw new DaoException("SQL Exception", e);
		}
		return books;
	}

	@Override
	public Book addBook(Book book) {
		try {
			PreparedStatement psmt = connection.prepareStatement(
					"insert into books(isbn,title,author,price) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

			psmt.setString(1, book.getIsbn());
			psmt.setString(2, book.getTitle());
			psmt.setString(3, book.getAuthor());
			psmt.setDouble(4, book.getPrice());

			psmt.executeUpdate();

			ResultSet rs = psmt.getGeneratedKeys();
			if (rs.next()) {
				book.setId(rs.getInt(1));
			}

		} catch (SQLException e) {
			throw new DaoException("SQL Exception", e);
		}

		return null;
	}

	public void deleteBook(int id) {
		try {
			PreparedStatement psmt = connection.prepareStatement("delete from books where id(?)");

			psmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("SQL Exception", e);
		}

	}

	public void updateBook(int id, Book book) {

	}

	public Book getBookById(int id) {
		Book book = null;
		try {
			PreparedStatement psmt = connection.prepareStatement("select from books where id(?)");
			psmt.setInt(1, id);

			ResultSet rs = psmt.executeQuery();

			book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
		} catch (SQLException e) {
			throw new DaoException("SQL Exception", e);
		}

		return book;
	}

}
