package net.terzeron.springboot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by terzeron on 2017. 1. 9..
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Value {
    private Long id;
    private String quote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Value() {

    }

    @Override
    public String toString() {
        return "Value{id=" + id + ", quote='" + quote + "'}";
    }

}
