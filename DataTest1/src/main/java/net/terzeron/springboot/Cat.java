package net.terzeron.springboot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@ToString
public class Cat {
    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Getter
    private String name;

    public Cat(String name) {
        this.name = name;
    }
}
