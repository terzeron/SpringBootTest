package com.terzeron.springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.io.Serializable;

// @Entity 어노테이션은 이 POJO가 DB의 entity임을 선언함
@Entity
@NamedQuery(name="Book.findByPrice", query="select name, author, price from Book b where b.price = ?1")
public class Book implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    long id;

    @Column(name="name")
    String name;

    @Column(name="author")
    String author;

    @Column(name="price")
    long price;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public static long getSerialVersionUID() {

        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public long getPrice() {
        return price;
    }
}
