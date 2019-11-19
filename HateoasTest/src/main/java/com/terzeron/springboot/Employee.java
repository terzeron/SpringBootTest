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
//    @NonNull
//    private String name;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String role;

    // firstname과 lastname이 추가되면서 발생한 문제를 해결하기 위해
    // constructor, getter와 setter를 따로 정의함
    public Employee(String name, String role) {
        setName(name);
        this.role = role;
    }

    public Employee(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setName(String name) {
        String[] parts = name.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }
}
