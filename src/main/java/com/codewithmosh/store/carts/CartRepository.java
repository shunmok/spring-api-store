package com.codewithmosh.store.carts;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {
// this is same as below, but mosh prefer using @EntityGraph
//    @Query("select c from Cart c join fetch c.items where c.id = ?1")

    @EntityGraph(attributePaths = "items.product")
    @Query("select c from Cart c where c.id = :cartId")
    Optional<Cart> getCartWithItems(@Param("cartId") UUID cartId);
}