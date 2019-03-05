package com.terzeron.springboot.repository;

import com.terzeron.springboot.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
