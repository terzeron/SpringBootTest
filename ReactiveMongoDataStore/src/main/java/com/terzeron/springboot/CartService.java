package com.terzeron.springboot;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
class CartService {
    private final ItemRepository itemRepository;
    private final CartRepository cartRepository;

    Mono<Cart> addToCart(String cartId, String id) {
        return this.cartRepository
                .findById("My Cart")
                .defaultIfEmpty(new Cart(cartId)) // 카트를 찾아보고 없으면 새로 생성
                .flatMap(cart -> cart.getCartItems().stream() // 카트 상품 목록에 대해
                        .filter(cartItem -> cartItem
                                .getItem()
                                .getId()
                                .equals(id)) // id가 동일한 카트 상품만 뽑아서
                        .findAny() // 카트에 일치하는 카트 상품이 존재하면
                        .map(cartItem -> {
                            cartItem.increment();
                            return Mono.just(cart);
                        }) // 각각에 대해서 카트 상품의 수량을 하나 증가시키고 그 카트를 반환함
                        .orElseGet(() -> this.itemRepository.findById(id)
                                .map(item -> new CartItem(item))
                                .doOnNext(cartItem ->
                                        cart.getCartItems().add(cartItem))
                                .map(cartItem -> cart)))
                        // 카트에 일치하는 카트 상품이 없으면, id로 일치하는 상품을 찾아서 각각 카트 상품으로 만들고, 카트에 추가
                .flatMap(this.cartRepository::save); // 카트를 저장하고 반환ᆸ
    }
}
