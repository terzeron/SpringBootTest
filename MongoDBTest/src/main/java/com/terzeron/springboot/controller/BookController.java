package com.terzeron.springboot.controller;

import com.terzeron.springboot.model.Book;
import com.terzeron.springboot.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookRepository bookRepository;

    public Map<String, Object> createBook(@RequestBody Map<String, Object> bookMap) {
        Book book = new Book(
                bookMap.get("name").toString(),
                bookMap.get("isbn").toString(),
                bookMap.get("author").toString(),
                Integer.parseInt(bookMap.get("pages").toString()
                ));
        bookRepository.save(book);
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "Book created successfully");
        response.put("book", book);
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
    public Book getBookDetails(@PathVariable("bookId") String bookId) {
        return bookRepository.findById(bookId).get();
    }

    @RequestMapping(method = RequestMethod.PUT, value="/{bookId}")
    public Map<String, Object> editBook(@PathVariable("bookId") String bookId,
                                        @RequestBody Map<String, Object> bookMap){
        Book book = new Book(bookMap.get("name").toString(),
                bookMap.get("isbn").toString(),
                bookMap.get("author").toString(),
                Integer.parseInt(bookMap.get("pages").toString()));
        book.setId(bookId);

        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "Book Updated successfully");
        response.put("book", bookRepository.save(book));
        return response;
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/{bookId}")
    public Map<String, String> deleteBook(@PathVariable("bookId") String bookId){
        bookRepository.deleteById(bookId);
        Map<String, String> response = new HashMap<String, String>();
        response.put("message", "Book deleted successfully");

        return response;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getAllBooks(){
        List<Book> books = bookRepository.findAll();
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("totalBooks", books.size());
        response.put("books", books);
        return response;
    }
}
