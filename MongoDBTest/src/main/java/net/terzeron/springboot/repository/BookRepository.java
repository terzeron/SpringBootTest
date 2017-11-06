package net.terzeron.springboot.repository;

import net.terzeron.springboot.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
