package com.example.marvelstore.MarvelStore.Repository;

import com.example.marvelstore.MarvelStore.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByActiveAndUsersId(Boolean active, Integer id);
}
