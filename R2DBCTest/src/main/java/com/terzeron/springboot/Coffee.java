package com.terzeron.springboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@ToString
public class Coffee {
    @Id
    private Integer id;
    private String name;
    private Integer price;
}
