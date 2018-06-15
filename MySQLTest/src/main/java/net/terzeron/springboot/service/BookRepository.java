package net.terzeron.springboot.service;

import net.terzeron.springboot.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
