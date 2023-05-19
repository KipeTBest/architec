package ru.kpfu.architec.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.architec.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/cart")
    public String getCart() {
        return "cart";
    }
}
