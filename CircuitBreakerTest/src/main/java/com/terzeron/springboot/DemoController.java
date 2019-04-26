package com.terzeron.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/")
    public Mono<String> home() {
        return demoService.slow();
    }

}
