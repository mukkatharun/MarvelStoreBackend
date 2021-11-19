package com.example.marvelstore.MarvelStore.Repository;

import com.example.marvelstore.MarvelStore.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

//    List<Orders> findAllByUserId (Integer id);

    List<Orders> findAllByUsersId (Integer id);

}
