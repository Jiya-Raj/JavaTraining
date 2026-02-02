package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

    @Query("SELECT b FROM Book b WHERE b.author = :author")
    List<Book> findByAuthor(@Param("author") String author);

    @Query("SELECT b FROM Book b WHERE b.price < :price")
    List<Book> findByPriceLessThan(@Param("price") Double price);

    @Query("DELETE FROM Book b WHERE b.title = :title")
    void deleteByTitle(@Param("title") String title);

    @Query("SELECT b FROM Book b WHERE b.title LIKE %:keyword%")
    List<Book> searchByTitle(@Param("keyword") String keyword);

    @Query("SELECT b FROM Book b ORDER BY b.price DESC")
    List<Book> sortByPriceDesc();

    @Query(
      value = "SELECT * FROM books WHERE price BETWEEN ?1 AND ?2",
      nativeQuery = true
    )
    List<Book> findByPriceRange(double min, double max);
}

