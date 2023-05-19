package ru.kpfu.architec.repositories;

import org.springframework.data.jpa.repository.Query;
import ru.kpfu.architec.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);

    @Query(value = "SELECT * FROM products p WHERE p.price > (SELECT AVG(p.price) FROM products)", nativeQuery = true)
    List<Product> getProductByAvgPrice();

    @Query(value = "SELECT * FROM products p WHERE p.city = 'Казань'", nativeQuery = true)
    List<Product> findAllProductsWhereCityIsKazan();
}
