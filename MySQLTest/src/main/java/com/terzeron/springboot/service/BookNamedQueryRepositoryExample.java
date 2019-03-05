package com.terzeron.springboot.service;

import com.terzeron.springboot.domain.Book;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BookNamedQueryRepositoryExample extends Repository<Book, Long> {
    List<Book> findByPrice(long price);
}
