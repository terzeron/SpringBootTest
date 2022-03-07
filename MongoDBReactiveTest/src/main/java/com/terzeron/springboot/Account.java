package com.terzeron.springboot;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account {

    @Id
    private String id;
    private String owner;
    private Double value;

    public void setId(String id) {
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public Double getValue() {
        return value;
    }

    public Account(String id, String owner, Double value) {
        this.id = id;
        this.owner = owner;
        this.value = value;
    }
}

