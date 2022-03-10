package com.terzeron.springboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class BlockHoundIntegrationTest {
    AltInventoryService inventoryService;

    @MockBean
    ItemRepository itemRepository;
    @MockBean
    CartRepository cartRepository;

    @BeforeEach
    void setUp() {
        Item sampleItem = new Item("item1", "TV tray", "Alf TV tray", 19.99);
        CartItem sampleCartItem = new CartItem(sampleItem);
        Cart sampleCart = new Cart("My Cart", Collections.singletonList(sampleCartItem));

        // Mono.empty의 경우, 런타임에서 최적화되면서 blockhound의 검사를 건너뛸 수 있으므로 숨김(최적화 방지)
        when(cartRepository.findById(anyString()))
                .thenReturn(Mono.<Cart>empty().hide());
        when(itemRepository.findById(anyString()))
                .thenReturn(Mono.just(sampleItem));
        when(cartRepository.save(any(Cart.class)))
                .thenReturn(Mono.just(sampleCart));

        inventoryService = new AltInventoryService(itemRepository, cartRepository);
    }

    @Test
    void blockHoundShouldTrapBlockingCall() {
        Mono.delay(Duration.ofSeconds(1))
                .flatMap(tick -> inventoryService.addItemToCart("My Cart", "item1"))
                .as(StepVerifier::create)
                //.verifyComplete();
                .verifyErrorSatisfies(throwable -> {
                    assertThat(throwable).hasMessageContaining("block()/blockFirst()/blockLast() are blocking");
                });
    }
}
