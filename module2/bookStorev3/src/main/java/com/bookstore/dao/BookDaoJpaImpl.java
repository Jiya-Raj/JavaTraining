package com.bookstore.dao;

import com.bookstore.exception.*;
import java.util.*;
import com.bookstore.dto.Book;
import com.bookstore.util.EntityManFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class BookDaoJpaImpl implements BookDao {

	public BookDaoJpaImpl() {

	}

	@Override
	public List<Book> getAllBooks() {
		EntityManager em = EntityManFactory.getEntityManager();
		List<Book> books = new ArrayList<>();
//		try {
//			Statement statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery("select * from books");
//			while (rs.next()) {
//				books.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
//			}
//
//		} catch (SQLException e) {
//			throw new DaoException("SQL Exception", e);
//		}
		try {
			books = em.createQuery("from Book").getResultList();
		} catch (PersistenceException e) {
			throw new DaoException("Error Fetching Book", e);
		} finally {
			em.close();
		}
		return books;
	}

	@Override
	public Book addBook(Book book) {
		EntityManager em = EntityManFactory.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
//			PreparedStatement psmt = connection.prepareStatement(
//					"insert into books(isbn,title,author,price) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
//
//			psmt.setString(1, book.getIsbn());
//			psmt.setString(2, book.getTitle());
//			psmt.setString(3, book.getAuthor());
//			psmt.setDouble(4, book.getPrice());
//
//			psmt.executeUpdate();
//
//			ResultSet rs = psmt.getGeneratedKeys();
//			if (rs.next()) {
//				book.setId(rs.getInt(1));
//			}
			tx.begin();
			em.persist(book);
			tx.commit();
			return book;
		} catch (PersistenceException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new DaoException("Error adding Book", e);
		} finally {
			em.close();
		}

	}

	public void deleteBook(int id) {
		EntityManager em = EntityManFactory.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Book book = em.find(Book.class, id);
			if (book != null) {
				em.remove(book);
			}
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new DaoException("Error Deleting Book", e);
		} finally {
			em.close();
		}

	}

	public void updateBook(int id, Book nbook) {
		EntityManager em = EntityManFactory.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Book book = em.find(Book.class, id);
			if (book != null) {
				book.setAuthor(nbook.getAuthor());
				book.setTitle(nbook.getTitle());
				book.setPrice(nbook.getPrice());
			}
			em.merge(book);
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new DaoException("Error Updating Book", e);
		} finally {
			em.close();
		}

	}

	public Book getBookById(int id) {
		EntityManager em = EntityManFactory.getEntityManager();
		Book book = null;

		try {
			book = em.find(Book.class, id);

		} catch (PersistenceException e) {
			throw new DaoException("Error Fetching Book", e);
		} finally {
			em.close();
		}

		return book;
	}

}
