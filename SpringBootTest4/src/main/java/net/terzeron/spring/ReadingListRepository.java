package net.terzeron.spring;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by terzeron on 2016. 4. 20..
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
