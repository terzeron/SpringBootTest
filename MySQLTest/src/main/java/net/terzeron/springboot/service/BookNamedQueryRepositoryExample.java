package net.terzeron.springboot.service;

import net.terzeron.springboot.domain.Book;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BookNamedQueryRepositoryExample extends Repository<Book, Long> {
    List<Book> findByPrice(long price);
}
