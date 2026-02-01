package com.app.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.entity.Book;


public interface BookRepo {
	public Book save(Book book);

	public Book findById(Integer id);

	public List<Book> findAll();

	public void deleteById(Integer id);
}
