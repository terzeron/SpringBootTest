package net.terzeron.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by terzeron on 2017. 1. 12..
 */
@RestController
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }
}
