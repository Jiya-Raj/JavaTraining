package com.app.util;

import com.app.dto.BookDto;
import com.app.entity.Book;

public class BookConverter {

	public static BookDto convertToBookDto(Book book) {
		if (book == null) {
			return null;
		}

		BookDto dto = new BookDto();
		dto.setTitle(book.getTitle());
		dto.setAuthor(book.getAuthor());
		dto.setPrice(book.getPrice());

		return dto;
	}

	public static Book convertToBook(BookDto dto) {
		if (dto == null) {
			return null;
		}

		Book book = new Book();
		book.setAuthor(dto.getAuthor());
		book.setTitle(dto.getTitle());
		book.setPrice(dto.getPrice());
		
		return book;
	}
}
