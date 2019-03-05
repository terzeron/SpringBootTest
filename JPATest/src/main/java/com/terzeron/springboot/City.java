package com.terzeron.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class City implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    protected City() {

    }

    public City(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return this.country;
    }
}
