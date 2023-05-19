package ru.kpfu.architec.repositories;

import ru.kpfu.architec.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
