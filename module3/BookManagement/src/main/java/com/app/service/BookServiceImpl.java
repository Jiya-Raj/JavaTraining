package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.dto.BookDto;
import com.app.entity.Book;
import com.app.repository.BookRepo;
import com.app.util.BookConverter;

@Service
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
		Book BookToUpdate =repo.findById(id);
		
		BookToUpdate.setTitle(dto.getTitle());
		BookToUpdate.setAuthor(dto.getAuthor());
		BookToUpdate.setPrice(dto.getPrice());
		
		Book updatedBook=repo.save(BookToUpdate);
		
		return BookConverter.convertToBookDto(updatedBook);
	}

	@Override
	public BookDto getBook(Integer id) {
		
		return BookConverter.convertToBookDto(repo.findById(id));
	}

	@Override
	public List<BookDto> getAllBooks() {
		return repo.findAll().stream().map(BookConverter::convertToBookDto).toList();
	}
	
	@Override
	public void deleteBook(Integer id) {
	    repo.deleteById(id);

	}

}
