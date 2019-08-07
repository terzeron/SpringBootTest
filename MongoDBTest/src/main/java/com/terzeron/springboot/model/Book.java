package com.terzeron.springboot.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Book {
    @Id
    private String id;
    private String name;
    private String isbn;
    private String author;
    private int pages;

    public Book(String name, String isbn, String author, int pages) {
        this.name = name;
        this.isbn = isbn;
        this.author = author;
        this.pages = pages;
    }
}
