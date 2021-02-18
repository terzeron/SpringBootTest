package com.terzeron.springboot;

import org.springframework.ldap.core.AttributesMapper;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

public class UserAttributesMapper implements AttributesMapper {
    public User mapFromAttributes(Attributes attributes) throws NamingException {
        User userObject = new User();

        String commonName = (String) attributes.get("cn").get();
        userObject.setCommonName(commonName);
        if (attributes.get("telephoneNumber") == null) {
            System.out.println("Telephone is null for " + commonName);
        } else {
            String telephone = attributes.get("telephoneNumber").get().toString();
            userObject.setTelephone(telephone);
        }
        return userObject;
    }
}
