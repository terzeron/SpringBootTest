package com.terzeron.springboot;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
@AllArgsConstructor
public class HomeController {
    private InventoryService inventoryService;

    @GetMapping
    Mono<Rendering> home() {
        return Mono.just(Rendering.view("home.html")
                .modelAttribute("items", this.inventoryService.getInventory())
                .modelAttribute("cart", this.inventoryService.getCart("My Cart")
                        .defaultIfEmpty(new Cart("My Cart")))
                .build());
    }

    @PostMapping("/add/{id}")
    Mono<String> addToCart(@PathVariable String id) {
        return this.inventoryService.addItemToCart("My Cart", id)
                .thenReturn("redirect:/");
    }

    /*
    @GetMapping("/search1")
    Mono<Rendering> search1(@RequestParam(required = false) String name,
                            @RequestParam(required = false) String description,
                            @RequestParam boolean useAnd) {
        return Mono.just(Rendering.view("home.html")
                .modelAttribute("items", inventoryService.search(name, description, useAnd))
                .modelAttribute("cart", this.cartRepository.findById("My Cart").defaultIfEmpty(new Cart("My Cart")))
                .build());
    }
     */

    /*
    @GetMapping("/search")
    Mono<Rendering> search(@RequestParam(required = false) String name,
                           @RequestParam(required = false) String description,
                           @RequestParam boolean useAnd) {
        return Mono.just(Rendering.view("home.html")
                .modelAttribute("items",
                        inventoryService.searchByFluentExample(name, description, useAnd))
                .modelAttribute("cart", this.cartRepository.findById("My Cart").defaultIfEmpty(new Cart("My " +
                        "Cart")))
                .build());
    }
     */
}
