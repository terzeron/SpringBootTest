package com.terzeron.springboot;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

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

    Flux<Item> findByNameContaining(String partialName);

    //@Query("{ 'name': ?0, 'age': ?1 }")
    //Flux<Item> findItemsForCustomerMonthlyReport(String name, int age);

    //@Query(sort = "{ 'age': -1}")
    //Flux<Item> findSortedStuffForWeeklyReport();

    Flux<Item> findByNameContainingIgnoreCase(String partialName);

    Flux<Item> findByDescriptionContainingIgnoreCase(String partialName);

    Flux<Item> findByNameContainingAndDescriptionContainingAllIgnoreCase(String partialName, String partialDesc);

    Flux<Item> findByNameContainingOrDescriptionContainingAllIgnoreCase(String partialName, String partialDesc);
}
