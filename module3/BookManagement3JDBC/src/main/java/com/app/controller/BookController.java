package com.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookDto;
import com.app.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	private final BookService service;

	public BookController(BookService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<BookDto> add(@RequestBody BookDto dto) {
		BookDto saved = service.addBook(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookDto> get(@PathVariable Integer id) {
		return ResponseEntity.ok(service.getBook(id));
	}

	@GetMapping
	public ResponseEntity<List<BookDto>> getAll() {
		return ResponseEntity.ok(service.getAllBooks());
	}

	@PutMapping("/{id}")
	public ResponseEntity<BookDto> update(@PathVariable Integer id, @RequestBody BookDto dto) {

		BookDto updated = service.updateBook(id, dto);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.deleteBook(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/author/{author}")
	public ResponseEntity<List<BookDto>> getByAuthor(@PathVariable String author) {
		return ResponseEntity.ok(service.findByAuthor(author));
	}

	@GetMapping("/price-range")
	public ResponseEntity<List<BookDto>> getByPriceRange(@RequestParam double min, @RequestParam double max) {
		return ResponseEntity.ok(service.findByPriceRange(min, max));
	}
}
