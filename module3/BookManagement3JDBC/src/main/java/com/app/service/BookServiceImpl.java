package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.Exception.ResourceNotFoundException;
import com.app.dto.BookDto;
import com.app.entity.Book;
import com.app.repository.BookJdbcRepo;
import com.app.repository.BookNamedRepo;
import com.app.util.BookConverter;

@Service
public class BookServiceImpl implements BookService {

	private final BookJdbcRepo jdbcRepo;
	private final BookNamedRepo namedRepo;

	public BookServiceImpl(BookJdbcRepo jdbcRepo, BookNamedRepo namedRepo) {
		this.jdbcRepo = jdbcRepo;
		this.namedRepo = namedRepo;
	}

	@Override
	public BookDto addBook(BookDto dto) {
		Book book = BookConverter.convertToBook(dto);
		Book saved = jdbcRepo.save(book);
		return BookConverter.convertToBookDto(saved);
	}

	@Override
	public BookDto getBook(int id) {
		Book book = jdbcRepo.findById(id);
		if (book == null) {
			throw new ResourceNotFoundException("Book not found");
		}
		return BookConverter.convertToBookDto(book);
	}

	@Override
	public List<BookDto> getAllBooks() {
		return jdbcRepo.findAll().stream().map(BookConverter::convertToBookDto).toList();
	}

	@Override
	public void deleteBook(int id) {
		jdbcRepo.delete(id);

	}

	@Override
	public BookDto updateBook(int id, BookDto dto) {
		Book book = BookConverter.convertToBook(dto);
		book.setId(id);

		Book updated = jdbcRepo.update(book);
		return BookConverter.convertToBookDto(updated);
	}

	@Override
	public List<BookDto> findByAuthor(String author) {
		return namedRepo.findByAuthor(author).stream().map(BookConverter::convertToBookDto).toList();
	}

	@Override
	public List<BookDto> findByPriceRange(double min, double max) {
		return namedRepo.findByPriceRange(min, max).stream().map(BookConverter::convertToBookDto).toList();
	}

}
