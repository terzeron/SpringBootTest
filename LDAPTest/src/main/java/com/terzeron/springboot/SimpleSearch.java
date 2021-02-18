package com.terzeron.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication

public class SimpleSearch {
    @Autowired
    private LdapTemplate ldapTemplate;

    public Set<User> getAllUsers(String surName) {
        UserAttributesMapper mapper = new UserAttributesMapper();
        AndFilter filterObject = new AndFilter();
        filterObject.and(new EqualsFilter("objectClass", "person"));
        filterObject.and(new EqualsFilter("sn", surName));
        return new HashSet<User>(ldapTemplate.search("ou=users,ou=system", "(objectClass=person)", mapper));
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleSearch.class, args);
        SimpleSearch simpleSearch = new SimpleSearch();
        for (User user : simpleSearch.getAllUsers("David")) {
            System.out.println(user);
        }
    }
}
