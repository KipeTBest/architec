package ru.kpfu.architec.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "wishlists")
@Getter
@Setter
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private User user;

    @ManyToMany
    @JoinTable(
            name = "wishlist_products",
            joinColumns = { @JoinColumn(name = "wishlist_id")},
            inverseJoinColumns = { @JoinColumn(name = "product_id")}
    )
    private Set<Product> products;
}
