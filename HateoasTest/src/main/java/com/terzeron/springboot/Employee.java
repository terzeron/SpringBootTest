package com.terzeron.springboot;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String role;

    // firstname과 lastname이 추가되면서 발생한 문제를 해결하기 위해
    // constructor, getter와 setter를 따로 정의함
    Employee(String name, String role) {
        this.firstName = "";
        this.lastName = "";
        this.role = role;
        setName(name);
    }

    String getName() {
        return this.firstName + " " + this.lastName;
    }

    void setName(String name) {
        String[] parts = name.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }
}
