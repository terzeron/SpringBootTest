package com.terzeron.springboot;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ItemRepository extends ReactiveCrudRepository<Item, String> {
    // save()
    // saveAll()
    // findById()
    // findAll()
    // findAllById()
    // existsById()
    // count()
    // deleteById()
    // delete()
    // deleteAll()
}
