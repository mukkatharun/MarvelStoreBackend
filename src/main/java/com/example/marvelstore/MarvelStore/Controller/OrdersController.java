package com.example.marvelstore.MarvelStore.Controller;

import com.example.marvelstore.MarvelStore.Model.Orders;
import com.example.marvelstore.MarvelStore.Model.Product;
import com.example.marvelstore.MarvelStore.Model.Users;
import com.example.marvelstore.MarvelStore.ModelDTO.OrderDTO;
import com.example.marvelstore.MarvelStore.Repository.OrdersRepository;
import com.example.marvelstore.MarvelStore.Repository.UsersRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/Orders")
public class OrdersController {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public List<Orders> getAllOrders(@RequestParam(value = "userid", required = false) Integer userid) {
        List<Orders> orders = userid == null ? ordersRepository.findAll() : ordersRepository.findAllByUsersId(userid);
        return orders;
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable(value = "id") Integer id) {
        return ordersRepository.getById(id);
    }

    @PostMapping
    public Orders saveOrder(@RequestBody OrderDTO order){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        Optional<Users> user = usersRepository.findById(order.getUserId());
        Orders c = new Orders();
        c.setUsers(user.get());
        c.setAmount(order.getAmount());
        c.setImage(order.getImage());
        c.setTime(formatter.format(date));
        c.setName(order.getName());
        return ordersRepository.save(c);
    }
}
