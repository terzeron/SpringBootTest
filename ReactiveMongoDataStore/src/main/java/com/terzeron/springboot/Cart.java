package com.terzeron.springboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Cart {

    private @Id String id;
    private List<CartItem> cartItems;

    public Cart(String id) {
        this(id, new ArrayList<>());
    }
}
