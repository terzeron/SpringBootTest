package net.terzeron.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by terzeron on 2017. 3. 29..
 */
@Slf4j
@RestController
public class GreetingController {
    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/greeting")
    public HttpEntity<Greeting> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        Greeting greeting = new Greeting(101, String.format(TEMPLATE, name));

        // add "_links" : { "self": { "href": "http://naver.com" } }
        //greeting.add(new Link("http://naver.com"));

        // add "_links" : { "manager": {"href": "http://localhost:8080" } }
        //greeting.add(linkTo(GreetingController.class).withRel("manager"));

        // add "_links": { "self": { "href": "http://localhost:8080/greeting?name=World" } }
        //greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

        // "_links": { "salesperson": { "href": "http://localhost:8080/Hello,%20World!" } }
        //greeting.add(linkTo(GreetingController.class).slash(greeting.getContent()).withRel("salesperson"));

        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
    }
}

