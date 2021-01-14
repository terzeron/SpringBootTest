package com.terzeron.springboot;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

interface CoffeeRepository extends ReactiveCrudRepository<Coffee, Integer> {
    @Query("SELECT * FROM coffee WHERE name = $1 ORDER BY id DESC")
    Flux<Coffee> findByName(String name);

    //@Query("SELECT * FROM coffee WHERE name = :name")
    //Flux<Coffee> findByName(String name);
}
