package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Book;
import com.example.exception.BookNotFoundException;
import com.example.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public Book create(Book book) {
        return repository.save(book);
    }

    public Book getBook(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException("Book not found with id: " + id));
    }

    public List<Book> getAll() {
        return repository.findAll();
    }

    public Book update(Integer id, Book updated) {

        Book book = getBook(id);

        book.setTitle(updated.getTitle());
        book.setPrice(updated.getPrice());

        return repository.save(book);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
