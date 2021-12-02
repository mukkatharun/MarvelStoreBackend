package com.example.marvelstore.MarvelStore.Controller;

import com.example.marvelstore.MarvelStore.Model.Orders;
import com.example.marvelstore.MarvelStore.Model.Product;
import com.example.marvelstore.MarvelStore.Model.Users;
import com.example.marvelstore.MarvelStore.ModelDTO.OrderDTO;
import com.example.marvelstore.MarvelStore.Repository.OrdersRepository;
import com.example.marvelstore.MarvelStore.Repository.UsersRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public List<Orders> saveOrder(@RequestBody List<OrderDTO> orderDTOS){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        Optional<Users> user = usersRepository.findById(orderDTOS.get(0).getUserId());
        List<Orders> orders = new ArrayList<Orders>();
        orderDTOS.parallelStream().forEach(orderDTO -> {
            Orders c = new Orders();
            c.setUsers(user.get());
            c.setAmount(orderDTO.getAmount());
            c.setImage(orderDTO.getImage());
            c.setTime(formatter.format(date));
            c.setName(orderDTO.getName());
            orders.add(c);
        });

        return ordersRepository.saveAll(orders);
    }
}
