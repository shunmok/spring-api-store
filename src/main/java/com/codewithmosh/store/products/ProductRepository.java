package com.codewithmosh.store.repositories;

import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.users.User;
import com.codewithmosh.store.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @EntityGraph(attributePaths = "category")
    List<Product> findByCategoryId(Byte categoryId);

//    @Query("select p from Product p join fetch p.category")
    @EntityGraph(attributePaths = "category")
    @Query("select p from Product p")
    List<Product> findAllWithCategory();

    @AllArgsConstructor
    @Service
    class AuthService {
        private final UserRepository userRepository;

        public User getCurrentUser() {
            var authentication = SecurityContextHolder.getContext().getAuthentication();
            var userId = (Long) authentication.getPrincipal();
            return userRepository.findById(userId).orElse(null);
        }

    }
}