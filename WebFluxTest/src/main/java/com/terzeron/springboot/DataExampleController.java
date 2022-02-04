package com.terzeron.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class DataExampleController {
    private final PersonRepository repo;

    @Autowired
    public DataExampleController(PersonRepository repo) {
        this.repo = repo;
    }

    @GetMapping("data")
    Flux<Sir> getAll() {
        return repo.findAll();
    }

    @GetMapping("data/{id}")
    public Mono<ResponseEntity<Sir>> hello(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.status(404).body(null));
    }
}
