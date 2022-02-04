package com.terzeron.springboot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

// https://www.infoq.com/articles/reactor-by-example/
// https://developpaper.com/spring-5-responsive-programming/
// curl localhost:8080/hello/mike
// curl localhost:8080/helloDelay/mike
// curl -X POST -H "Content-Type: application/json" -d '{"firstName": "Paul","lastName": "tEsT"}' localhost:8080/heyMister

@RestController
public class ExampleController {
    private final MyReactiveLibrary reactiveLibrary;

    public ExampleController(MyReactiveLibrary reactiveLibrary) {
        this.reactiveLibrary = reactiveLibrary;
    }

    @GetMapping("hello/{who}")
    public Mono<String> hello(@PathVariable String who) {
        return Mono.just(who)
                .map(w -> "Hello " + w + "!");
    }

    @GetMapping("helloDelay/{who}")
    public Mono<String> helloDelay(@PathVariable String who) {
        return reactiveLibrary.withDelay("Hello " + who + "!!", 2);
    }

    @PostMapping("heyMister")
    public Flux<String> hey(@RequestBody String body) throws IOException {
        // 원문의 예제는 webflux 이전의 web-reactive 의존성에 기반한 것이어서
        // deserialization이 필요함
        // 아래 코드는 anti-pattern이니 webflux의 ServerRequest를 사용할 것
        ObjectMapper mapper = new ObjectMapper();
        Sir sir = mapper.readValue(body, Sir.class);
        return Mono.just("Hey mister ")
                .concatWith(
                        Flux.fromArray(sir.getLastName().split(""))
                                .map(String::toUpperCase)
                                .take(1))
                .concatWith(Mono.just(". how are you?"));
    }
}
