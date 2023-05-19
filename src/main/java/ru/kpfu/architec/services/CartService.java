package ru.kpfu.architec.services;

import ru.kpfu.architec.models.Cart;
import ru.kpfu.architec.models.Product;
import ru.kpfu.architec.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public Cart addToCart(Product product, Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException());
        cart.getProducts().add(product);
        return cart;
    }
}
