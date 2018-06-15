package net.terzeron.springboot.service;

import net.terzeron.springboot.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookOwnRepository bookOwnRepository;
    @Autowired
    private BookQueryRepositoryExample bookQueryRepository;
    @Autowired
    private BookNamedQueryRepositoryExample bookNamedQueryRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findByName(String name) {
        return bookQueryRepository.findByName(name);
    }

    @Override
    public List<Book> findByPrice(long price) {
        return bookNamedQueryRepository.findByPrice(price);
    }

    @Override
    public List<Book> findByNameAndAuthor(String name, String author) {
        return bookOwnRepository.findByNameAndAuthor(name, author);
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findOne(long id) {
        System.out.println("Cached Pages");
        return bookRepository.findOne(id);
    }

    @Override
    public void delete(long id) {
        bookRepository.delete(id);
    }


    @Override
    public List<Book> findByPriceRange(long price1, long price2) {
        return bookQueryRepository.findByPriceRange(price1, price2);
    }

    @Override
    public List<Book> findByNameMatch(String name) {
        return null;
    }

    @Override
    public List<Book> findByNamedParam(String name, String author, long price) {
        return bookQueryRepository.findByNamedParam(name, author, price);
    }
}
