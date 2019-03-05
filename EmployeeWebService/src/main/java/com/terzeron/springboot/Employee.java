package com.terzeron.springboot;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    @Id
    @NotNull
    @Size(max = 64)
    @Column(name = "id", nullable = false, updatable = false)
    @Getter
    @Setter
    private String id;

    @NotNull
    @Size(max = 64)
    @Column(name = "name", nullable = false)
    @Getter
    @Setter
    private String name;

    @NotNull
    @Size(max = 64)
    @Column(name = "city", nullable = false)
    @Getter
    @Setter
    private String city;
}
