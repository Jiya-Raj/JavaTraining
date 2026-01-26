package com.bookstore.controller;

import java.util.Scanner;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookDaoJpaImpl;
import com.bookstore.dto.Book;
import com.bookstore.exception.*;
import com.bookstore.service.BookService;
import com.bookstore.service.BookServiceImpl;

import java.util.*;

public class BookStoreController {
	BookService bookService;

	public BookStoreController() {
		BookDao dao = new BookDaoJpaImpl();
		this.bookService = new BookServiceImpl(dao);
	}

	public static void main(String[] args) {
		new BookStoreController().BookStore();
//		BookDao dao = new BookDaoJpaImpl();
//        BookService service = new BookServiceImpl(dao);
//
//        // TC-1 Add books
//        Book b1 = service.addBook(new Book("ISBN-1", "Java Basics", "James", 300));
//        Book b2 = service.addBook(new Book("ISBN-2", "Spring Boot", "Pivotal", 500));
//
//        System.out.println("Added Books:");
//        System.out.println(b1);
//        System.out.println(b2);
//
//        // TC-2 Get all books
//        System.out.println("\nAll Books:");
//        List<Book> books = service.getAllBooks();
//        books.forEach(System.out::println);
//
//        // TC-3 Get book by ID
//        System.out.println("\nBook with ID " + b1.getId());
//        System.out.println(service.getBookById(b1.getId()));
//
//        // TC-4 Update book
//        service.updateBook(b1.getId(),
//                new Book("ISBN-1", "Java Advanced", "James Gosling", 450));
//
//        System.out.println("\nAfter Update:");
//        System.out.println(service.getBookById(b1.getId()));
//
//        // TC-5 Delete book
//        service.deleteBook(b2.getId());
//
//        System.out.println("\nAfter Deletion:");
//        service.getAllBooks().forEach(System.out::println);
	}

	public void BookStore() {
		int id;
		String isbn;
		String Title;
		String Author;
		double price;
		System.out.println("Choose a Number for the operation you want to perform");
		System.out.println("1 Add Book");
		System.out.println("2 Edit Book");
		System.out.println("3 delete Book");
		System.out.println("4 Search Book");
		System.out.println("5 List Books");
		System.out.println("6 Exit");

		while (true) {
			System.out.print("Enter Number: ");

			Scanner sc = new Scanner(System.in);
			int menu = sc.nextInt();
			try {
				switch (menu) {
				case 1:
					System.out.println("Enter Book isbn");
					isbn = sc.nextLine();
					System.out.println("Enter Book Title");
					Title = sc.nextLine();
					System.out.println("Enter Book Author");
					Author = sc.nextLine();
					System.out.println("Enter Book Price");
					price = sc.nextDouble();
					bookService.addBook(new Book(isbn, Title, Author, price));
					System.out.println("Book added successfully");
					break;
				case 2:
					System.out.println("Enter Book ID");
					id = sc.nextInt();
					System.out.println("Enter Book isbn");
					isbn = sc.nextLine();
					System.out.println("Enter Book Title");
					Title = sc.nextLine();
					System.out.println("Enter Book Author");
					Author = sc.nextLine();
					System.out.println("Enter Book Price");
					price = sc.nextDouble();
					bookService.updateBook(id, new Book(isbn, Title, Author, price));
					break;
				case 3:
					System.out.println("Enter Book ID");
					id = sc.nextInt();
					bookService.deleteBook(id);
					break;
				case 4:
					System.out.println("Enter Book ID");
					id = sc.nextInt();
					bookService.getBookById(id);
					break;
				case 5:
					List<Book> books = bookService.getAllBooks();
					for (Book book : books) {
						System.out.println(book);
					}
					break;
				case 6:
					break;
				default:
					System.out.println("Enter valid Number or 6 to Exit");
				}
			} catch (ServiceException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
