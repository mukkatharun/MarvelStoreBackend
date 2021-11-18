package com.example.marvelstore.MarvelStore.Repository;

import com.example.marvelstore.MarvelStore.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
