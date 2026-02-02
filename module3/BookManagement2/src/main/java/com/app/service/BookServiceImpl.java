package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.Exception.ResourceNotFoundException;
import com.app.dto.BookDto;
import com.app.entity.Book;
import com.app.repository.BookRepo;
import com.app.util.BookConverter;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	private final BookRepo repo;

	public BookServiceImpl(BookRepo repo) {
		this.repo = repo;
	}

	@Override
	public BookDto addBook(BookDto dto) {
		return BookConverter.convertToBookDto(repo.save(BookConverter.convertToBook(dto)));
	}

	@Override
	public BookDto updateBook(Integer id, BookDto dto) {
		Book BookToUpdate = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
		;

		BookToUpdate.setTitle(dto.getTitle());
		BookToUpdate.setAuthor(dto.getAuthor());
		BookToUpdate.setPrice(dto.getPrice());

		Book updatedBook = repo.save(BookToUpdate);

		return BookConverter.convertToBookDto(updatedBook);
	}

	@Override
	public BookDto getBook(Integer id) {
		Book book = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
		return BookConverter.convertToBookDto(book);
	}

	@Override
	public List<BookDto> getAllBooks() {
		return repo.findAll().stream().map(BookConverter::convertToBookDto).toList();
	}

	@Override
	public void deleteBook(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public List<BookDto> findByAuthor(String author) {
		return repo.findByAuthor(author).stream().map(BookConverter::convertToBookDto).toList();
	}

	@Override
	public List<BookDto> findByPriceLessThan(Double price) {
		return repo.findByPriceLessThan(price).stream().map(BookConverter::convertToBookDto).toList();
	}

	@Override
	public void deleteByTitle(String title) {
		repo.deleteByTitle(title);
	}

	@Override
	public List<BookDto> searchByTitle(String keyword) {
		return repo.searchByTitle(keyword).stream().map(BookConverter::convertToBookDto).toList();
	}

	@Override
	public List<BookDto> sortByPriceDesc() {
		return repo.sortByPriceDesc().stream().map(BookConverter::convertToBookDto).toList();
	}

	@Override
	public List<BookDto> findByPriceRange(double min, double max) {
		return repo.findByPriceRange(min, max).stream().map(BookConverter::convertToBookDto).toList();
	}

}
