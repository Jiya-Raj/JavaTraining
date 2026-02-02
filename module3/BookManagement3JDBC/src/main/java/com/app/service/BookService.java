package com.app.service;

import java.util.List;

import com.app.dto.BookDto;

public interface BookService {
	BookDto addBook(BookDto b);

    BookDto getBook(int id);

    List<BookDto> getAllBooks();

    BookDto updateBook(int id, BookDto b);

    void deleteBook(int id);

    List<BookDto> findByAuthor(String author);

    List<BookDto> findByPriceRange(double min, double max);
}
