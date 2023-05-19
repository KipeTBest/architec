package ru.kpfu.architec.repositories;

import ru.kpfu.architec.models.User;
import ru.kpfu.architec.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    Wishlist findByUser(User user);
}
