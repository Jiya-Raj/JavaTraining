package com.example.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Book;
import com.example.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository repository;

    @PostMapping
    @PreAuthorize("hasAnyRole('STUDENT','TEACHER')")
    public Book create(@RequestBody Book book) {
        return repository.save(book);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('STUDENT','TEACHER')")
    public List<Book> getAll() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('TEACHER')")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
