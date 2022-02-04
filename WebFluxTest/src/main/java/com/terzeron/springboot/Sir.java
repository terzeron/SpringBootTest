package com.terzeron.springboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
@AllArgsConstructor
public class Sir {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
}
