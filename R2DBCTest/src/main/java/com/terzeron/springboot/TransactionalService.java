package com.terzeron.springboot;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
class TransactionalService {
    private final @NonNull CoffeeRepository repository;

    @Transactional
    public Mono<Coffee> save(Coffee coffee) {
        return repository.save(coffee);
    }
}