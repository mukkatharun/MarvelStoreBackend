package com.example.marvelstore.MarvelStore.Controller;

import com.example.marvelstore.MarvelStore.Model.Cart;
import com.example.marvelstore.MarvelStore.Model.Orders;
import com.example.marvelstore.MarvelStore.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @GetMapping
    public List<Cart> getAllOrders(@RequestParam(value = "userid", required = true) Integer userid) {
        List<Cart> cartList = cartRepository.findAllByActiveAndUsersId( true, userid);
        return cartList;
    }

    @PostMapping
    public Cart saveToCart(@RequestBody Cart order){
        return cartRepository.save(order);
    }

}
