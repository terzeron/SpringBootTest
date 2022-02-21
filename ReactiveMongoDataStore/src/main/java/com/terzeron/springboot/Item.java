package com.terzeron.springboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private @Id String id;
    private String name;
    private String description;
    private double price;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    Item(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
