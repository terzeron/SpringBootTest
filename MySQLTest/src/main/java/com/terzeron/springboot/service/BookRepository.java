package com.terzeron.springboot.service;

import com.terzeron.springboot.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
