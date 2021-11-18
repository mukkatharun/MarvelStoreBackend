package com.example.marvelstore.MarvelStore.Controller;

import com.example.marvelstore.MarvelStore.Model.Orders;
import com.example.marvelstore.MarvelStore.Model.Product;
import com.example.marvelstore.MarvelStore.Repository.OrdersRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrdersController {
    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping
    public List<Orders> getAllOrders(){
        return ordersRepository.findAll();
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable(value = "id") Integer id) {
        return ordersRepository.getById(id);
    }

    @PostMapping
    public Orders saveOrder(@RequestBody Orders order){
        return ordersRepository.save(order);
    }
}
