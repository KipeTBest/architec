package ru.kpfu.architec.controllers;

import ru.kpfu.architec.models.Product;
import ru.kpfu.architec.models.Wishlist;
import ru.kpfu.architec.services.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class WishlistController {
    private final WishlistService wishlistService;

    @GetMapping("/wishlist")
    public String products(Principal principal, Model model) {
        Wishlist wishlist = wishlistService.findWishlistByUser(wishlistService.getUserByPrincipal(principal));
        model.addAttribute("products", wishlist.getProducts());
        return "wishlist-products";
    }

    @PutMapping("/wishlist/add")
    @ResponseStatus(HttpStatus.OK)
    public void addProduct(Product product, Principal principal/*, Model model*/) {
        Wishlist wishlist = wishlistService.findWishlistByUser(wishlistService.getUserByPrincipal(principal));
        wishlistService.addProductToWishlist(wishlist, product);
    }

    @DeleteMapping("/wishlist/remove")
    @ResponseStatus(HttpStatus.OK)
    public void removeProduct(Product product, Principal principal/*, Model model*/) {
        Wishlist wishlist = wishlistService.findWishlistByUser(wishlistService.getUserByPrincipal(principal));
        wishlistService.removeProductFromWishlist(wishlist, product);
    }
}
