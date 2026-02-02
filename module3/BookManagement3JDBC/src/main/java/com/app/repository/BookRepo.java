package com.app.repository;

import java.util.List;

import com.app.entity.Book;

public interface BookRepo {
	public Book save(Book b);

	public Book findById(int id);

	public List<Book> findAll();

	public Book update(Book b);

	public void delete(int id);
}
