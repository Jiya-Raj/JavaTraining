package com.app.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.entity.Book;
import com.app.util.BookConverter;

@Repository
public class BookJdbcRepo implements BookRepo {
	private final JdbcTemplate jdbc;

	public BookJdbcRepo(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public Book save(Book b) {
		jdbc.update("INSERT INTO books_jdbc(title, author, price) VALUES (?, ?, ?)", b.getTitle(), b.getAuthor(),
				b.getPrice());
		return b;
	}

	@Override
	public Book findById(int id) {
		return jdbc.queryForObject("SELECT * FROM books_jdbc WHERE id = ?", new BookRowMapper(), id);
	}

	@Override
	public List<Book> findAll() {
		return jdbc.query("SELECT * FROM books_jdbc", new BookRowMapper());
	}

	@Override
	public Book update(Book b) {
		jdbc.update("UPDATE books_jdbc SET title=?, author=?, price=? WHERE id=?", b.getTitle(), b.getAuthor(),
				b.getPrice(), b.getId());
		return b;
	}

	@Override
	public void delete(int id) {
		jdbc.update("DELETE FROM books_jdbc WHERE id=?", id);
	}

}
