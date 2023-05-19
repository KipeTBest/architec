package ru.kpfu.architec.services;

import ru.kpfu.architec.models.Product;
import ru.kpfu.architec.models.User;
import ru.kpfu.architec.models.Wishlist;
import ru.kpfu.architec.repositories.UserRepository;
import ru.kpfu.architec.repositories.WishlistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@Slf4j
@RequiredArgsConstructor
public class WishlistService {
    private WishlistRepository wishlistRepository;

    private final UserRepository userRepository;

    public void createWishlist(User user) {
        Wishlist wishlist = new Wishlist();
        wishlist.setUser(user);
        wishlistRepository.save(wishlist);
    }

    public Wishlist findWishlistByUser(User user) {
        return wishlistRepository.findByUser(user);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public void addProductToWishlist(Wishlist wishlist, Product product) {
        wishlist.getProducts().add(product);
        wishlistRepository.save(wishlist);
    }

    public void removeProductFromWishlist(Wishlist wishlist, Product product) {
        wishlist.getProducts().remove(product);
        wishlistRepository.save(wishlist);
    }
}
