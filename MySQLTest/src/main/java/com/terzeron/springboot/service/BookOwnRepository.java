package com.terzeron.springboot.service;

import com.terzeron.springboot.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BookOwnRepository extends Repository<Book, Long> {
    @Query(value="select author from Book b where b.author=?1")
    List<Book> findByName(String name);
    List<Book> findByNameAndAuthor(String name, String author);
}
