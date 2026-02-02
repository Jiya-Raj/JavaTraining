package com.app.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.entity.Book;

@Repository
public class BookNamedRepo {
	private final NamedParameterJdbcTemplate namedJdbc;

    public BookNamedRepo(NamedParameterJdbcTemplate namedJdbc) {
        this.namedJdbc = namedJdbc;
    }
    
    public List<Book> findByAuthor(String author) {
        String sql = "SELECT * FROM books_jdbc WHERE author = :author";

        Map<String, Object> params = new HashMap<>();
        params.put("author", author);

        return namedJdbc.query(sql, params, new BookRowMapper());
    }

    public List<Book> findByPriceRange(double min, double max) {
        String sql = "SELECT * FROM books_jdbc WHERE price BETWEEN :min AND :max";

        Map<String, Object> params = new HashMap<>();
        params.put("min", min);
        params.put("max", max);

        return namedJdbc.query(sql, params, new BookRowMapper());
    }

}
